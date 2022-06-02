package br.com.gustavodiniz.clientsapi.controllers;

import br.com.gustavodiniz.clientsapi.dtos.ServiceProvidedDTO;
import br.com.gustavodiniz.clientsapi.models.ClientModel;
import br.com.gustavodiniz.clientsapi.models.ServiceProvidedModel;
import br.com.gustavodiniz.clientsapi.repositories.ClientRepository;
import br.com.gustavodiniz.clientsapi.repositories.ServiceProvidedRepository;
import br.com.gustavodiniz.clientsapi.services.ClientService;
import br.com.gustavodiniz.clientsapi.services.ServiceProvidedService;
import br.com.gustavodiniz.clientsapi.utils.BigDecimalConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequiredArgsConstructor
@RequestMapping("/services-provided")
public class ServiceProvidedController {

    @Autowired
    private ServiceProvidedService serviceProvidedService;


    @PostMapping
    public ResponseEntity<ServiceProvidedDTO> create(@RequestBody @Valid ServiceProvidedDTO serviceProvidedDTO) {

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(serviceProvidedService.create(serviceProvidedDTO).getId()).toUri();

        return ResponseEntity.created(uri).build();
    }
}
