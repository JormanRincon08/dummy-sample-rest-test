package com.restapiexample.dummy.tasks;

import com.restapiexample.dummy.interactions.ExecutePut;
import com.restapiexample.dummy.models.CurrentEmployee;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;


import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EditEmployee implements Task {
    private final String endpointResource;

    public EditEmployee(String endpointResource) {
        this.endpointResource = endpointResource;
    }

    public static EditEmployee service(String endpointResource) {
        return instrumented(EditEmployee.class, endpointResource);
    }

    @Override
    @Step("{0} consume service /edit")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(ExecutePut.service(endpointResource).withId(CurrentEmployee.getEmployeeId()).andBody(Serenity.sessionVariableCalled("Request").toString()));
    }

}
