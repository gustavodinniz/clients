package br.com.gustavodiniz.clientsapi.services;

import br.com.gustavodiniz.clientsapi.dtos.UserDTO;
import br.com.gustavodiniz.clientsapi.models.UserModel;

public interface UserService {
    UserModel create(UserDTO userDTO);
}
