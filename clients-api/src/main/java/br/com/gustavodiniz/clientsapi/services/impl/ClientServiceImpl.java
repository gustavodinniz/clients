package br.com.gustavodiniz.clientsapi.services.impl;

import br.com.gustavodiniz.clientsapi.dtos.ClientDTO;
import br.com.gustavodiniz.clientsapi.models.ClientModel;
import br.com.gustavodiniz.clientsapi.repositories.ClientRepository;
import br.com.gustavodiniz.clientsapi.services.ClientService;
import br.com.gustavodiniz.clientsapi.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ClientModel> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public ClientModel create(ClientDTO clientDTO) {
        return clientRepository.save(modelMapper.map(clientDTO, ClientModel.class));
    }

    @Override
    public ClientModel findById(Integer id) {
        Optional<ClientModel> clientModelOptional = clientRepository.findById(id);
        return clientModelOptional.orElseThrow(() -> new ObjectNotFoundException("Client not found."));
    }

    @Override
    public void delete(Integer id) {
        findById(id);
        clientRepository.deleteById(id);
    }

    @Override
    public ClientModel update(ClientDTO clientDTO) {
        return clientRepository.save(modelMapper.map(clientDTO, ClientModel.class));
    }
}
