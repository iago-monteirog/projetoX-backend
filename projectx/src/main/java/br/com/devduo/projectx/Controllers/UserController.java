package br.com.devduo.projectx.Controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.devduo.projectx.modules.entities.UserEntity;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

  @PostMapping("/")
  public void create(@Valid @RequestBody UserEntity user) {
    System.out.println("Usuário criado!");
    System.out.println(user.getUsername());
  }
}
