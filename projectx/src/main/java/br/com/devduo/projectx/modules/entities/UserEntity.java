package br.com.devduo.projectx.modules.entities;

import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UserEntity {
  private UUID id;
  private String name;

  @Pattern(regexp = "\\S+", message = "O campo [username] não deve conter espaços.")
  private String username;

  @Email(message = "O campo [email] deve conter um e-mail válido")
  private String email;

  @Length(min = 10, max = 100, message = "A senha deve ter entre (10) e (100) caracteres")
  private String password;
  private String description;
}