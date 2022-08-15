package com.restapiexample.dummy.tasks;

import com.restapiexample.dummy.interactions.ExecuteDelete;
import com.restapiexample.dummy.models.CurrentEmployee;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DeleteEmployee implements Task {
    private final String endpointResource;

    public DeleteEmployee(String endpointResource) {
        this.endpointResource = endpointResource;
    }

    public static DeleteEmployee service(String endpointResource) {
        return instrumented(DeleteEmployee.class, endpointResource);
    }

    @Override
    @Step("{0} consume service /delete/{id}")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(ExecuteDelete.service(endpointResource).withParameter(CurrentEmployee.getEmployeeId()));
    }
}
