package com.restapiexample.dummy.models;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("profile_image")
    private String profileImage;
}
