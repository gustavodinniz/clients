package br.com.gustavodiniz.clientsapi.exceptions;

public class UserAlreadyRegisteredException extends RuntimeException {
    public UserAlreadyRegisteredException(String username) {
        super("User already registered: " + username);
    }
}
