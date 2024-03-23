package br.com.devduo.projectx.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.devduo.projectx.modules.entities.UserEntity;
import br.com.devduo.projectx.modules.services.CreateUserUseCase;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
  @Autowired
  private CreateUserUseCase createUserUseCase;

  @PostMapping("/")
  public ResponseEntity<Object> create(@Valid @RequestBody UserEntity user) {
    try {
      var result = this.createUserUseCase.execute(user);
      return ResponseEntity.ok().body(result);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }
}
