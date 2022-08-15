package com.restapiexample.dummy.questions.editemployee;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.hamcrest.Matchers;

import static com.restapiexample.dummy.utils.constants.Manager.*;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class FieldsResponseEditEmployeeServiceAre implements Question<Boolean> {

    private FieldsResponseEditEmployeeServiceAre() {
    }

    public static FieldsResponseEditEmployeeServiceAre expected() {
        return new FieldsResponseEditEmployeeServiceAre();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.should(
                seeThatResponse("Validation fields post employee service",
                        response -> response
                                .assertThat()
                                .and().body(ROOT_JSON_PATH, Matchers.hasKey(KEY_STATUS_PATH))
                                .and().body(ROOT_JSON_PATH, Matchers.hasKey(KEY_EMPLOYEE_DATA))
                                .and().body(KEY_EMPLOYEE_DATA, Matchers.hasKey(KEY_EMPLOYEE_NAME))
                                .and().body(KEY_EMPLOYEE_DATA, Matchers.hasKey(KEY_EMPLOYEE_SALARY))
                                .and().body(KEY_EMPLOYEE_DATA, Matchers.hasKey(KEY_EMPLOYEE_AGE))
                                .and().body(KEY_EMPLOYEE_DATA, Matchers.hasKey(KEY_PROFILE_IMAGE))
                                .and().body(ROOT_JSON_PATH, Matchers.hasKey(KEY_MESSAGE_PATH))
                )
        );
        return true;
    }
}
