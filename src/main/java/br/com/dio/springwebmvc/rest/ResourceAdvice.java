package br.com.dio.springwebmvc.rest;

import br.com.dio.springwebmvc.exception.JediNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@ControllerAdvice
public class ResourceAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(JediNotFoundException.class)
    public void notFound() {
    }

}
