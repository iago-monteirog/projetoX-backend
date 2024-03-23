package br.com.devduo.projectx.modules.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.devduo.projectx.modules.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
  Optional<UserEntity> findByUsernameOrEmail(String username, String email);

  Optional<UserEntity> findByUsername(String username);
}
