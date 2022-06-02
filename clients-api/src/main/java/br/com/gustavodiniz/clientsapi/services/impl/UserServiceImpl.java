package br.com.gustavodiniz.clientsapi.services.impl;

import br.com.gustavodiniz.clientsapi.dtos.UserDTO;
import br.com.gustavodiniz.clientsapi.models.UserModel;
import br.com.gustavodiniz.clientsapi.repositories.UserRepository;
import br.com.gustavodiniz.clientsapi.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserModel create(UserDTO userDTO) {
        return userRepository.save(modelMapper.map(userDTO, UserModel.class));
    }
}
