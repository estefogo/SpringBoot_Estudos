package io.github.rafaestefogo.rest.exceptions;

public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException() {
        super("Product not found.");
    }
}