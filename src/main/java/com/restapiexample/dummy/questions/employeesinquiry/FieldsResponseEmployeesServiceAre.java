package com.restapiexample.dummy.questions.employeesinquiry;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.hamcrest.Matchers;

import static com.restapiexample.dummy.utils.constants.Manager.*;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class FieldsResponseEmployeesServiceAre implements Question<Boolean> {

    private FieldsResponseEmployeesServiceAre() {
    }

    public static FieldsResponseEmployeesServiceAre expected() {
        return new FieldsResponseEmployeesServiceAre();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.should(
                seeThatResponse("Validation fields get employees service",
                        response -> response
                                .assertThat()
                                .and().body(ROOT_JSON_PATH, Matchers.hasKey(KEY_STATUS_PATH))
                                .and().body(ROOT_JSON_PATH, Matchers.hasKey(KEY_EMPLOYEE_DATA))
                                .and().body(KEY_FIRST_EMPLOYEES_DATA, Matchers.hasKey(KEY_ID_EMPLOYEE))
                                .and().body(KEY_FIRST_EMPLOYEES_DATA, Matchers.hasKey(KEY_EMPLOYEES_NAME))
                                .and().body(KEY_FIRST_EMPLOYEES_DATA, Matchers.hasKey(KEY_EMPLOYEES_SALARY))
                                .and().body(KEY_FIRST_EMPLOYEES_DATA, Matchers.hasKey(KEY_EMPLOYEES_AGE))
                                .and().body(KEY_FIRST_EMPLOYEES_DATA, Matchers.hasKey(KEY_PROFILE_IMAGE))
                                .and().body(ROOT_JSON_PATH, Matchers.hasKey(KEY_MESSAGE_PATH))
                )
        );
        return true;
    }
}
