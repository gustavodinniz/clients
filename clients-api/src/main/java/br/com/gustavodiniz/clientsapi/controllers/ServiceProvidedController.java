package br.com.gustavodiniz.clientsapi.controllers;

import br.com.gustavodiniz.clientsapi.dtos.ServiceProvidedDTO;
import br.com.gustavodiniz.clientsapi.services.ServiceProvidedService;
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
