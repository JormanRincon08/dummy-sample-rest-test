package com.restapiexample.dummy.exceptions;

public class AssertionServicesError extends AssertionError {
    public static final String STATUS_CODE_ERROR_MESSAGE = "The status code service response is not expected";
    public static final String QUANTITY_DATA_ERROR_MESSAGE = "The quantity data service response is not expected";
    public static final String SCHEMA_ERROR_MESSAGE = "The schema service response is not expected";
    public static final String FIELDS_ERROR_MESSAGE = "The fields in service response is not expected";
    public static final String FIELDS_VALUES_ERROR_MESSAGE = "The value fields in service response is not expected";

    public AssertionServicesError(String message) {
        super(message);
    }

    public AssertionServicesError(String message, Throwable cause) {
        super(message, cause);
    }
}
