package br.com.gustavodiniz.clientsapi.services;

import br.com.gustavodiniz.clientsapi.dtos.ServiceProvidedDTO;
import br.com.gustavodiniz.clientsapi.models.ServiceProvidedModel;

public interface ServiceProvidedService {
    ServiceProvidedModel create(ServiceProvidedDTO serviceProvidedDTO);
}
