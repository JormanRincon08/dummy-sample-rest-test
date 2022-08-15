package com.restapiexample.dummy.questions.employeesinquiry;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class QuantityEmployees implements Question<Boolean> {

    private final int expectedNumberEmployees;

    private QuantityEmployees(int expectedNumberEmployees) {
        this.expectedNumberEmployees = expectedNumberEmployees;
    }

    public static QuantityEmployees are(int expectedNumberEmployees) {
        return new QuantityEmployees(expectedNumberEmployees);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.should(
                seeThatResponse("Quantity employees",
                        response -> response
                                .assertThat()
                                .body("data", Matchers.hasSize(expectedNumberEmployees))
                )
        );
        return true;
    }
}
