package pl.bartoszzychal.starterkit.app.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.bartoszzychal.starterkit.app.client.model.entity.ClientEntity;

public interface ClientRepository extends JpaRepository<ClientEntity,Long> {

}
