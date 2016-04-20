package pl.bartoszzychal.starterkit.app.client.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.bartoszzychal.starterkit.app.client.mapper.ClientMapper;
import pl.bartoszzychal.starterkit.app.client.model.Client;
import pl.bartoszzychal.starterkit.app.client.model.to.ClientTo;
import pl.bartoszzychal.starterkit.app.client.repository.ClientRepository;
import pl.bartoszzychal.starterkit.app.client.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	ClientRepository clientRepository;
	

	@Override
	public List<ClientTo> findAll() {
		return ClientMapper.map2To(clientRepository.findAll());
	}


	@Override
	public void execute(Client client) {
		System.out.println(client.toString());
	}
}
