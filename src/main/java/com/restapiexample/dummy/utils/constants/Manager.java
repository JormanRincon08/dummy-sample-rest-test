package com.restapiexample.dummy.utils.constants;

public abstract class Manager {
    public static final String ROOT_JSON_PATH = "$";
    public static final String KEY_STATUS_PATH = "status";
    public static final String KEY_MESSAGE_PATH = "message";
    public static final String KEY_FIRST_EMPLOYEES_DATA = "data[0]";
    public static final String KEY_EMPLOYEE_DATA = "data";
    public static final String KEY_ID_EMPLOYEE = "id";
    public static final String KEY_EMPLOYEES_NAME = "employee_name";
    public static final String KEY_EMPLOYEES_SALARY = "employee_salary";
    public static final String KEY_EMPLOYEES_AGE = "employee_age";
    public static final String KEY_EMPLOYEE_NAME = "name";
    public static final String KEY_EMPLOYEE_SALARY = "salary";
    public static final String KEY_EMPLOYEE_AGE = "age";
    public static final String KEY_PROFILE_IMAGE = "profile_image";

    public static final String REPORT_TITLE_PUT_SERVICE = "Put service employee";

    public static final String STATUS_SUCCESS_MESSAGE = "success";
    public static final String GET_SUCCESS_MESSAGE = "Successfully! Record has been fetched.";
    public static final String POST_SUCCESS_MESSAGE = "Successfully! Record has been added.";
    public static final String PUT_SUCCESS_MESSAGE = "Successfully! Record has been updated.";
    public static final String DELETE_SUCCESS_MESSAGE = "Successfully! Record has been deleted";


    private Manager() {
    }
}
