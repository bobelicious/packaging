package com.l2.packaging.exceptions;

public class PackagingException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public PackagingException(String message) {
        super(message);
    }    
}
