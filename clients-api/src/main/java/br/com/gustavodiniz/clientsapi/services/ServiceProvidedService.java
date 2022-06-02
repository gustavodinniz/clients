package br.com.gustavodiniz.clientsapi.services;

import br.com.gustavodiniz.clientsapi.dtos.ServiceProvidedDTO;
import br.com.gustavodiniz.clientsapi.models.ServiceProvidedModel;

import java.util.List;

public interface ServiceProvidedService {
    ServiceProvidedModel create(ServiceProvidedDTO serviceProvidedDTO);

    List<ServiceProvidedModel> findByClientNameAndMonth(String name, Integer month);
}
