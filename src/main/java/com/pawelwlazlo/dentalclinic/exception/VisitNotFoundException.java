package com.pawelwlazlo.dentalclinic.exception;

public class VisitNotFoundException extends RuntimeException {
    public VisitNotFoundException(String message) {
        super(message);
    }
}
