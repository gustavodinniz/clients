package br.com.gustavodiniz.clientsapi.controllers;

import br.com.gustavodiniz.clientsapi.dtos.ServiceProvidedDTO;
import br.com.gustavodiniz.clientsapi.models.ServiceProvidedModel;
import br.com.gustavodiniz.clientsapi.services.ServiceProvidedService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

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

    public List<ServiceProvidedModel> search(
            @RequestParam(value = "name", required = false, defaultValue = "") String name,
            @RequestParam(value = "month", required = false) Integer month
    ) {
        return serviceProvidedService.findByClientNameAndMonth(name, month);
    }
}
