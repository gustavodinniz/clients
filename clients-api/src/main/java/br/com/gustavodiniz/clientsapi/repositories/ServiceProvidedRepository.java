package br.com.gustavodiniz.clientsapi.repositories;

import br.com.gustavodiniz.clientsapi.models.ServiceProvidedModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceProvidedRepository extends JpaRepository<ServiceProvidedModel, Integer> {
}
