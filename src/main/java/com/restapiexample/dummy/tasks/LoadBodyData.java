package com.restapiexample.dummy.tasks;

import com.restapiexample.dummy.interactions.PrepareBodyRequest;
import com.restapiexample.dummy.models.CurrentEmployee;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.util.List;

import static com.restapiexample.dummy.utils.constants.Manager.BODY_SCHEMA_PUT_SERVICE;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LoadBodyData implements Task {

    private final List<String> data;

    public LoadBodyData(List<String> data) {
        this.data = data;
    }

    public static LoadBodyData employee(List<String> data) {
        return instrumented(LoadBodyData.class, data);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        CurrentEmployee.load(data);
        actor.attemptsTo(PrepareBodyRequest.in(BODY_SCHEMA_PUT_SERVICE).with(CurrentEmployee.getEmployeeBodyData()));
    }
}
