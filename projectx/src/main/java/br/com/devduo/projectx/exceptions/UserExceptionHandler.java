package br.com.devduo.projectx.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.devduo.projectx.modules.dto.ErrorMessageDTO;

@ControllerAdvice
public class UserExceptionHandler {
  private MessageSource messageSource;

  public UserExceptionHandler(MessageSource message) {
    this.messageSource = message;
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<List<ErrorMessageDTO>> handleMethodArgumentNotValidException(
      MethodArgumentNotValidException exception) {
    List<ErrorMessageDTO> errorList = new ArrayList<>();

    exception.getBindingResult().getFieldErrors().forEach(err -> {
      if (err != null) {
        String message = messageSource.getMessage(err, LocaleContextHolder.getLocale());
        ErrorMessageDTO error = new ErrorMessageDTO(message, err.getField());
        errorList.add(error);
      }

    });

    return new ResponseEntity<>(errorList, HttpStatus.BAD_REQUEST);
  }
}
