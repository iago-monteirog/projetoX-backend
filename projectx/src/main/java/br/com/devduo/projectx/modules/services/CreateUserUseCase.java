package br.com.devduo.projectx.modules.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devduo.projectx.exceptions.UserFoundException;
import br.com.devduo.projectx.modules.entities.UserEntity;
import br.com.devduo.projectx.modules.repositories.UserRepository;

@Service
public class CreateUserUseCase {
  @Autowired
  private UserRepository userRepository;

  public UserEntity execute(UserEntity userEntity) {
    userRepository.findByUsernameOrEmail(userEntity.getUsername(), userEntity.getEmail())
        .ifPresent((user) -> {
          throw new UserFoundException();
        });

    return this.userRepository.save(userEntity);
  }
}
