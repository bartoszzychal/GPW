package pl.bartoszzychal.starterkit.app.simulation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import pl.bartoszzychal.starterkit.app.client.model.to.ClientTo;
import pl.bartoszzychal.starterkit.app.client.service.ClientService;

@Component("simulation")
public class Simulation {

	@Autowired
	ClientService clientService;
	
	public void run(){
	}
	
}
