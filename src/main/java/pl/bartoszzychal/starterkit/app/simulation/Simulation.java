package pl.bartoszzychal.starterkit.app.simulation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.bartoszzychal.starterkit.app.bank.service.BankServiceAdapter;
import pl.bartoszzychal.starterkit.app.broker.service.BrokerServiceAdapter;
import pl.bartoszzychal.starterkit.app.client.model.Client;
import pl.bartoszzychal.starterkit.app.client.model.to.ClientTo;
import pl.bartoszzychal.starterkit.app.client.service.ClientService;
import pl.bartoszzychal.starterkit.app.daily.DailySupervisor;

@Component("simulation")
public class Simulation {

	@Autowired
	private ClientService clientService;
	@Autowired
	private DailySupervisor dailySupervisor;
	@Autowired 
	private BrokerServiceAdapter brokerServiceAdapter;
	@Autowired 
	private BankServiceAdapter bankServiceAdapter;
	
	private final Logger LOG = org.slf4j.LoggerFactory.getLogger(getClass());
	
	public void run(){
		List<Client> allClient = getAllClient();
	//	while(dailySupervisor.getCurrentDay().before(dailySupervisor.getEndDay())){
			for (Client client : allClient) {
				clientService.execute(client);
			}
			Date nextDay = dailySupervisor.nextDay();
			LOG.info(nextDay.toString());
		//}
	}

	private List<Client> getAllClient() {
		List<ClientTo> allClient = clientService.findAll();
		List<Client> clients = new ArrayList<>();
		for (ClientTo clientTo : allClient) {
			clients.add(new Client(clientTo, brokerServiceAdapter, bankServiceAdapter));
		}
		return clients;
	}
	
}
