package br.com.gustavodiniz.clientsapi.controllers;

import br.com.gustavodiniz.clientsapi.dtos.UserDTO;
import br.com.gustavodiniz.clientsapi.exceptions.UserAlreadyRegisteredException;
import br.com.gustavodiniz.clientsapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody @Valid UserDTO userDTO) {
        try {
            URI uri = ServletUriComponentsBuilder
                    .fromCurrentRequest().path("/{id}")
                    .buildAndExpand(userService.create(userDTO).getId()).toUri();
            return ResponseEntity.created(uri).build();
        } catch (UserAlreadyRegisteredException exception) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage());
        }
    }
}
