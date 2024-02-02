package br.com.devduo.projectx.modules.user.Controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.devduo.projectx.modules.user.UserEntity;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

  public void create(@Valid @RequestBody UserEntity user) {
    System.out.println("Usuário criado!");
    System.out.println(user.getUsername());
  }
}
