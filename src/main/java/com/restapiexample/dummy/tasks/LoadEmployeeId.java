package com.restapiexample.dummy.tasks;

import com.restapiexample.dummy.models.CurrentEmployee;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;


import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LoadEmployeeId implements Task {

    private final String idEmployee;

    public LoadEmployeeId(String idEmployee) {
        this.idEmployee = idEmployee;
    }

    public static LoadEmployeeId from(String idEmployee) {
        return instrumented(LoadEmployeeId.class, idEmployee);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        CurrentEmployee.loadIdFrom(idEmployee);
    }
}
