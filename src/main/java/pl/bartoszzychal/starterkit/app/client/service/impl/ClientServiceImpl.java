package pl.bartoszzychal.starterkit.app.client.service.impl;

import java.math.BigDecimal;
import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.bartoszzychal.starterkit.app.bank.model.enums.Currency;
import pl.bartoszzychal.starterkit.app.bank.model.to.FundsTo;
import pl.bartoszzychal.starterkit.app.bank.model.utils.Confirmation;
import pl.bartoszzychal.starterkit.app.bank.service.BankService;
import pl.bartoszzychal.starterkit.app.broker.model.to.StockTo;
import pl.bartoszzychal.starterkit.app.broker.model.to.TransactionTo;
import pl.bartoszzychal.starterkit.app.broker.service.BrokerService;
import pl.bartoszzychal.starterkit.app.client.mapper.ClientMapper;
import pl.bartoszzychal.starterkit.app.client.model.Client;
import pl.bartoszzychal.starterkit.app.client.model.to.ClientTo;
import pl.bartoszzychal.starterkit.app.client.repository.ClientRepository;
import pl.bartoszzychal.starterkit.app.client.service.ClientService;
import pl.bartoszzychal.starterkit.app.daily.CurrentDay;
import pl.bartoszzychal.starterkit.app.money.Money;
import pl.bartoszzychal.starterkit.app.strategy.Strategy;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private BrokerService brokerService;

	@Autowired
	private BankService bankService;
	
	
	@Override
	public List<ClientTo> findAll() {
		return ClientMapper.map2To(clientRepository.findAll());
	}


	@Override
	public void execute(Client client) {
		Strategy clientStrategy = client.getStrategy();
		List<TransactionTo> suggestTransactions = clientStrategy.suggestTransactions();
		if(!suggestTransactions.isEmpty()){
			checkBrokerOffer(client, clientStrategy, suggestTransactions);
		}
	}


	private void checkBrokerOffer(Client client, Strategy clientStrategy, List<TransactionTo> suggestTransactions) {
		List<TransactionTo> prepareOfferByBroker = brokerService.prepareOffer(suggestTransactions);
		if(clientStrategy.analyzeBrokerOffer(prepareOfferByBroker)){
			makeTransactions(client, prepareOfferByBroker);
		}
	}


	private void makeTransactions(Client client, List<TransactionTo> suggestTransactions) {
		Money stockCost = calculateStockCost(suggestTransactions);
		Money fees = brokerService.calculateFees(suggestTransactions);
		List<FundsTo> funds = getClientFunds(client);
		Money cost = stockCost.add(fees);
		Money exchange = calculateExchangeToTransfer(funds,cost);
		exchangeMoneyToTransaction(client, exchange);
		Confirmation transfer = bankService.transfer(client.getAuthorization(), cost, brokerService.getBrokerAccountNumber());
		Confirmation brokerTransferConfirmation = brokerService.responseOffer(transfer, Boolean.TRUE);
		List<FundsTo> fundsAfterTransfer = getClientFunds(client);
		Money exchangeOnDayEnd = calculateExchangeOnDayEnd(fundsAfterTransfer);
		if(exchangeOnDayEnd!=null){
			exchangeMoneyOnDayEnd(client, exchangeOnDayEnd);
		}
	}


	private void exchangeMoneyToTransaction(Client client, Money exchange) {
		if(exchange!=null){
			List<FundsTo> fundsAfterExchange = bankService.exchange(client.getAuthorization(),Currency.EURO ,Currency.PLN,  exchange);
		}
	}


	private void exchangeMoneyOnDayEnd(Client client, Money exchangeOnDayEnd) {
		Money zero = new Money(new BigDecimal(0));
		Money PLNToEuro = bankService.getCurrentExchangeRate(Currency.PLN, Currency.EURO);
		Money EuroToPLN = bankService.getCurrentExchangeRate(Currency.EURO, Currency.PLN);
		Money max = Money.max(exchangeOnDayEnd,zero);
		if(max.equals(zero)){
			Money divide = exchangeOnDayEnd.divide(2);
			List<FundsTo> fundsAfterExchange = bankService.exchange(client.getAuthorization(),Currency.PLN ,Currency.EURO,  divide);						
		}else if(max.equals(exchangeOnDayEnd)){
			Money divide = exchangeOnDayEnd.divide(2);
			List<FundsTo> fundsAfterExchange = bankService.exchange(client.getAuthorization(),Currency.EURO ,Currency.PLN, divide);						
		}
	}


	private List<FundsTo> getClientFunds(Client client) {
		return bankService.getFunds(client.getAuthorization());
	}
	
	private Money calculateStockCost(List<TransactionTo> transactionTos){
		 if(!transactionTos.isEmpty()){
			 return transactionTos.stream().map(st->st.getPrice().multiply(st.getNumber())).reduce((m1,m2)->m1.add(m2)).get();			 
		 }
		 return new Money(new BigDecimal(0));
	}
	
	private Money calculateExchangeToTransfer(List<FundsTo> funds, Money need){
		 Money pln = getFunds(funds,Currency.PLN);
		 Money substract = pln.substract(need);
		 Money zero = new Money(new BigDecimal(0));
		 Money max = Money.max(substract,zero);
		 if(max.equals(zero)){
			 return Money.abs(substract);
		 }
		 return null;
	}
	
	private Money calculateExchangeOnDayEnd(List<FundsTo> funds){
		Money euro = getFunds(funds, Currency.EURO);
		Money pln = getFunds(funds, Currency.PLN);
		Money currentExchangeRate = bankService.getCurrentExchangeRate(Currency.EURO, Currency.PLN);
		Money substract = euro.multiply(currentExchangeRate).substract(pln);
		return substract;
	}

	private Money getFunds(List<FundsTo> funds,Currency currency) {
		return funds.stream().filter(f-> f.getCurrency()==currency).findFirst().get().getFund();
	}
}
