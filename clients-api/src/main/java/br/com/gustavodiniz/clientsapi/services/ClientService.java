package br.com.gustavodiniz.clientsapi.services;

import br.com.gustavodiniz.clientsapi.dtos.ClientDTO;
import br.com.gustavodiniz.clientsapi.models.ClientModel;

import java.util.List;

public interface ClientService {
    List<ClientModel> findAll();

    ClientModel create(ClientDTO clientDTO);

    ClientModel findById(Integer id);

    void delete(Integer id);

    ClientModel update(ClientDTO clientDTO);
}
