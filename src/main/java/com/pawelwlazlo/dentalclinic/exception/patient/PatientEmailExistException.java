package com.pawelwlazlo.dentalclinic.exception.patient;

public class PatientEmailExistException extends RuntimeException {

    public PatientEmailExistException(String message) {
        super(message);
    }


}
