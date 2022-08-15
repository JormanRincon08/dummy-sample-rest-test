package com.restapiexample.dummy.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class  EmployeeModel {
    private String name;
    private double salary;
    private int age;
    private String profile_image;
}
