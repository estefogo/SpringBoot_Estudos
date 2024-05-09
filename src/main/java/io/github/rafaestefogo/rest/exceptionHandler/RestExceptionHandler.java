package io.github.rafaestefogo.rest.exceptionHandler;

import io.github.rafaestefogo.rest.exceptions.ClientNotFoundException;
import io.github.rafaestefogo.rest.exceptions.OrderNotFoundException;
import io.github.rafaestefogo.rest.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ClientNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private String clientNotFoundExceptionHandler(ClientNotFoundException e) {
        return e.getMessage();
    }

    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private String productNotFoundExceptionandler(ProductNotFoundException e) {
        return e.getMessage();
    }

    @ExceptionHandler(OrderNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private String orderNotFoundExceptionHandler(OrderNotFoundException e) {
        return e.getMessage();
    }
}