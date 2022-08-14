package com.restapiexample.dummy.exceptions;

public class AssertionServicesError extends AssertionError {
    public static final String SERVICE_ERROR_MESSAGE = "Error in the execution of the service or the values obtained in the query are not the expected ones";

    public AssertionServicesError(String message) {
        super(message);
    }

    public AssertionServicesError(String message, Throwable cause) {
        super(message, cause);
    }
}
