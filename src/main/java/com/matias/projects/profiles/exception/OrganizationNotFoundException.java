package com.matias.projects.profiles.exception;

public class OrganizationNotFoundException extends RuntimeException {

    public OrganizationNotFoundException(String message) {
        super(message);
    }
    
    public OrganizationNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
