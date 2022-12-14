package com.restapiexample.dummy.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = {"src/test/resources/features/employees/inquiry/employees_inquiry.feature"},
        glue = {"com.restapiexample.dummy.stepdefinitions"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class EmployeesInquiry {
}
