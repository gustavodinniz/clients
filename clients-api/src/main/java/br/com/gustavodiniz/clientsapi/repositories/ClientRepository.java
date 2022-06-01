package br.com.gustavodiniz.clientsapi.repositories;

import br.com.gustavodiniz.clientsapi.models.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientModel, Integer> {
}
