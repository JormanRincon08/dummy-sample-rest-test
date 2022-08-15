package com.restapiexample.dummy.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = {"src/test/resources/features/employees/edit/edit_employee.feature"},
        glue = {"com.restapiexample.dummy.stepdefinitions"},
        tags = "@editEmployee",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class EditEmployee {
}
