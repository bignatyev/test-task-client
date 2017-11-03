package com.taskombanktesttask.clientjournal.exceptions;

/**
 * Thrown by client api service to indicate
 * that api returned error
 */
public class ClientApiErrorException extends Exception {
    public ClientApiErrorException(String message) {
        super(message);
    }
}
