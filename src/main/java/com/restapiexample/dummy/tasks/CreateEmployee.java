package com.restapiexample.dummy.tasks;

import com.github.javafaker.Faker;
import com.restapiexample.dummy.interactions.ExecutePost;
import com.restapiexample.dummy.models.EmployeeModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

import java.security.SecureRandom;
import java.util.Locale;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CreateEmployee implements Task {
    private final String endpointResource;
    private static final Faker employeeFaker = Faker.instance(new Locale("es", "CO"), new SecureRandom());

    public CreateEmployee(String endpointResource) {
        this.endpointResource = endpointResource;
    }

    public static CreateEmployee service(String endpointResource) {
        return instrumented(CreateEmployee.class, endpointResource);
    }

    @Override
    @Step("{0} consume service /create")
    public <T extends Actor> void performAs(T actor) {
        EmployeeModel employee = createEmployeeData();
        actor.attemptsTo(ExecutePost.service(endpointResource).withBody(employee));
    }

    private EmployeeModel createEmployeeData() {
        return EmployeeModel.builder()
                .name(String.format("%s %s", employeeFaker.name().firstName(), employeeFaker.name().lastName()))
                .salary(employeeFaker.number().randomNumber(5, true))
                .age(employeeFaker.number().numberBetween(18, 90))
                .profileImage(employeeFaker.avatar().image())
                .build();
    }
}
