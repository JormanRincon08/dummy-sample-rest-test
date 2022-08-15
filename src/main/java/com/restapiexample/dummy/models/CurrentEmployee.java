package com.restapiexample.dummy.models;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.restapiexample.dummy.utils.constants.Manager.*;

public class CurrentEmployee {

    @Getter
    private static List<String> employeeBodyData;
    @Getter
    private static String employeeId;
    @Getter
    private static Map<String, Object> employeeMapData;

    private CurrentEmployee() {
    }

    public static void loadIdFrom(String employeeId) {
        CurrentEmployee.employeeId = employeeId;
    }

    public static void load(List<String> data) {
        List<String> requestData = new ArrayList<>();
        requestData.add(data.get(1));
        requestData.add(data.get(2));
        requestData.add(data.get(3));
        requestData.add(data.get(4));
        CurrentEmployee.employeeBodyData = requestData;
        CurrentEmployee.employeeMapData = createEmployeeMapData(data);
        CurrentEmployee.employeeId = data.get(0);
    }

    private static Map<String, Object> createEmployeeMapData(List<String> data) {
        Map<String, Object> employeeMapData = new HashMap<>();
        employeeMapData.put(KEY_ID_EMPLOYEE, data.get(0));
        employeeMapData.put(KEY_EMPLOYEE_NAME, data.get(1));
        employeeMapData.put(KEY_EMPLOYEE_SALARY, data.get(2));
        employeeMapData.put(KEY_EMPLOYEE_AGE, data.get(3));
        employeeMapData.put(KEY_PROFILE_IMAGE, data.get(4));
        return employeeMapData;
    }
}
