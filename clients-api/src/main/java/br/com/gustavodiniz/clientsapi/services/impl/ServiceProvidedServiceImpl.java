package br.com.gustavodiniz.clientsapi.services.impl;

import br.com.gustavodiniz.clientsapi.dtos.ServiceProvidedDTO;
import br.com.gustavodiniz.clientsapi.models.ClientModel;
import br.com.gustavodiniz.clientsapi.models.ServiceProvidedModel;
import br.com.gustavodiniz.clientsapi.repositories.ServiceProvidedRepository;
import br.com.gustavodiniz.clientsapi.services.ClientService;
import br.com.gustavodiniz.clientsapi.services.ServiceProvidedService;
import br.com.gustavodiniz.clientsapi.utils.BigDecimalConverter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class ServiceProvidedServiceImpl implements ServiceProvidedService {

    @Autowired
    private ServiceProvidedRepository serviceProvidedRepository;

    @Autowired
    private BigDecimalConverter bigDecimalConverter;

    @Autowired
    private ClientService clientService;

    @Override
    public ServiceProvidedModel create(ServiceProvidedDTO serviceProvidedDTO) {
        LocalDate localDate = LocalDate.parse(serviceProvidedDTO.getServiceDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Integer clientId = serviceProvidedDTO.getClientId();

        ClientModel client = clientService.findById(clientId);

        ServiceProvidedModel serviceProvided = new ServiceProvidedModel();
        serviceProvided.setDescription(serviceProvidedDTO.getDescription());
        serviceProvided.setServiceDate(localDate);
        serviceProvided.setClient(client);
        serviceProvided.setServiceValue(bigDecimalConverter.converter(serviceProvidedDTO.getServiceValue()));

        return serviceProvidedRepository.save(serviceProvided);
    }
}
