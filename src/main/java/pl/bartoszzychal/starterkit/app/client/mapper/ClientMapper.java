package pl.bartoszzychal.starterkit.app.client.mapper;

import java.util.List;
import java.util.stream.Collectors;

import pl.bartoszzychal.starterkit.app.client.model.entity.ClientEntity;
import pl.bartoszzychal.starterkit.app.client.model.to.ClientTo;

public class ClientMapper {
	public static ClientTo map(ClientEntity clientEntity){
		return new ClientTo(clientEntity.getId(), clientEntity.getAccountNumber(), clientEntity.getAccountPassword());
	}
	
	public static ClientEntity map(ClientTo clientTo){
		return new ClientEntity(clientTo.getId(),clientTo.getAccountNumber(),clientTo.getAccountPassword());
	}
	
	public static List<ClientEntity> map2Entity(List<ClientTo> clientTos){
		return clientTos.stream().map(ClientMapper::map).collect(Collectors.toList());
	}
	
	public static List<ClientTo> map2To(List<ClientEntity> clientTos){
		return clientTos.stream().map(ClientMapper::map).collect(Collectors.toList());
	}
	
	
}
