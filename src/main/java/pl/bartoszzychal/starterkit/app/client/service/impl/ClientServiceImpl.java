package pl.bartoszzychal.starterkit.app.client.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.bartoszzychal.starterkit.app.client.mapper.ClientMapper;
import pl.bartoszzychal.starterkit.app.client.model.to.ClientTo;
import pl.bartoszzychal.starterkit.app.client.repository.ClientRepository;
import pl.bartoszzychal.starterkit.app.client.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	ClientRepository clientRepository;
	
	public ClientTo addNewClient(ClientTo clientTo){
		return ClientMapper.map(clientRepository.save(ClientMapper.map(clientTo)));	
	}
}
