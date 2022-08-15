package com.restapiexample.dummy.questions.employeeinquiry;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.hamcrest.Matchers;

import static com.restapiexample.dummy.utils.constants.Manager.*;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class FieldsResponseEmployeeServiceAre implements Question<Boolean> {

    private FieldsResponseEmployeeServiceAre() {
    }

    public static FieldsResponseEmployeeServiceAre expected() {
        return new FieldsResponseEmployeeServiceAre();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.should(
                seeThatResponse("Validation fields get employee service",
                        response -> response
                                .assertThat()
                                .and().body(ROOT_JSON_PATH, Matchers.hasKey(KEY_STATUS_PATH))
                                .and().body(ROOT_JSON_PATH, Matchers.hasKey(KEY_EMPLOYEE_DATA))
                                .and().body(KEY_EMPLOYEE_DATA, Matchers.hasKey(KEY_ID_EMPLOYEE))
                                .and().body(KEY_EMPLOYEE_DATA, Matchers.hasKey(KEY_EMPLOYEES_NAME))
                                .and().body(KEY_EMPLOYEE_DATA, Matchers.hasKey(KEY_EMPLOYEES_SALARY))
                                .and().body(KEY_EMPLOYEE_DATA, Matchers.hasKey(KEY_EMPLOYEES_AGE))
                                .and().body(KEY_EMPLOYEE_DATA, Matchers.hasKey(KEY_PROFILE_IMAGE))
                                .and().body(ROOT_JSON_PATH, Matchers.hasKey(KEY_EMPLOYEE_DATA))
                )
        );
        return true;
    }
}
