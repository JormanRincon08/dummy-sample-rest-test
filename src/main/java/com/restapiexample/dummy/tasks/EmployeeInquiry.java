package com.restapiexample.dummy.tasks;

import com.restapiexample.dummy.interactions.ExecuteGetParameters;
import com.restapiexample.dummy.models.CurrentEmployee;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EmployeeInquiry implements Task {
    private final String endpointResource;

    public EmployeeInquiry(String endpointResource) {
        this.endpointResource = endpointResource;
    }

    public static EmployeeInquiry service(String endpointResource) {
        return instrumented(EmployeeInquiry.class, endpointResource);
    }

    @Override
    @Step("{0} consume service /employee/{id}")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(ExecuteGetParameters.service(endpointResource).withParameter(CurrentEmployee.getEmployeeId()));
    }
}
