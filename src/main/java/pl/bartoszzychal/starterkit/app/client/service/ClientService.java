package pl.bartoszzychal.starterkit.app.client.service;

import java.util.List;

import pl.bartoszzychal.starterkit.app.client.model.Client;
import pl.bartoszzychal.starterkit.app.client.model.to.ClientTo;

public interface ClientService {
	List<ClientTo> findAll();
	void execute(Client client);
}
