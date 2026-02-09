package com.spring.system.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String resourceName, Object id) {
        super(resourceName + " con id " + id + " no encontrado");
    }
}