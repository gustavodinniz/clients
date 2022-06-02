package br.com.gustavodiniz.clientsapi.controllers;

import br.com.gustavodiniz.clientsapi.dtos.ClientDTO;
import br.com.gustavodiniz.clientsapi.models.ClientModel;
import br.com.gustavodiniz.clientsapi.services.ClientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<ClientDTO>> findAll() {
        var clientDTO = clientService.findAll()
                .stream()
                .map(x -> modelMapper.map(x, ClientDTO.class)).collect(Collectors.toList());
        return ResponseEntity.ok().body(clientDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientDTO> findById(@PathVariable Integer id) {
        ClientModel clientModel = clientService.findById(id);
        return ResponseEntity.ok().body(modelMapper.map(clientModel, ClientDTO.class));
    }

    @PostMapping
    public ResponseEntity<ClientDTO> create(@RequestBody @Valid ClientDTO clientDTO) {
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(clientService.create(clientDTO).getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ClientDTO> delete(@PathVariable Integer id) {
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientDTO> update(@PathVariable Integer id, @RequestBody @Valid ClientDTO clientDTO) {
        clientDTO.setId(id);
        ClientModel clientModel = clientService.update(clientDTO);
        return ResponseEntity.ok().body(modelMapper.map(clientModel, ClientDTO.class));
    }
}
