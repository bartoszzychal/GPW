package pl.bartoszzychal.starterkit.app.strategyFactory;

import pl.bartoszzychal.starterkit.app.bank.model.utils.Authorization;
import pl.bartoszzychal.starterkit.app.bank.service.BankServiceAdapter;
import pl.bartoszzychal.starterkit.app.broker.service.BrokerServiceAdapter;
import pl.bartoszzychal.starterkit.app.strategy.Strategy;
import pl.bartoszzychal.starterkit.app.strategy.impl.LargeBrainStrategy;
import pl.bartoszzychal.starterkit.app.strategy.impl.MediumBrainStrategy;
import pl.bartoszzychal.starterkit.app.strategy.impl.SmallBrainStrategy;

public class StrategyFactory {
	public static Strategy getStrategy(Long idClient,Authorization authorization, BrokerServiceAdapter brokerService,
			BankServiceAdapter bankService){
		Long strategyID = idClient%3;
		Strategy strategy = null;
		if(strategyID == 1){
			strategy = new SmallBrainStrategy(authorization, brokerService, bankService);
		}else if(strategyID == 2) {
			strategy = new MediumBrainStrategy(authorization, brokerService, bankService);
		}else if (strategyID == 3) {
			strategy = new LargeBrainStrategy(authorization, brokerService, bankService);
		}
		return strategy;
	}
}
