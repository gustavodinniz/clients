package br.com.gustavodiniz.clientsapi.repositories;

import br.com.gustavodiniz.clientsapi.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Integer> {
}
