package com.restapiexample.dummy.tasks;

import com.restapiexample.dummy.interactions.ExecuteGet;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EmployeesInquiry implements Task {
    private final String endpointResource;

    public EmployeesInquiry(String endpointResource) {
        this.endpointResource = endpointResource;
    }

    public static EmployeesInquiry service(String endpointResource) {
        return instrumented(EmployeesInquiry.class, endpointResource);
    }

    @Override
    @Step("{0} consume service /employees")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(ExecuteGet.service(endpointResource));
    }
}
