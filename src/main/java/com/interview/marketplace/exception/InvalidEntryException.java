package com.interview.marketplace.exception;

public class InvalidEntryException extends RuntimeException{
    public InvalidEntryException(String message) {
        super(message);
    }
}