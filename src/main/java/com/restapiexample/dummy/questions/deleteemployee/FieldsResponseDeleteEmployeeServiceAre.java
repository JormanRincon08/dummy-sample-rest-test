package com.restapiexample.dummy.questions.deleteemployee;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.hamcrest.Matchers;

import static com.restapiexample.dummy.utils.constants.Manager.*;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class FieldsResponseDeleteEmployeeServiceAre implements Question<Boolean> {

    private FieldsResponseDeleteEmployeeServiceAre() {
    }

    public static FieldsResponseDeleteEmployeeServiceAre expected() {
        return new FieldsResponseDeleteEmployeeServiceAre();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.should(
                seeThatResponse("Validation fields delete employee service",
                        response -> response
                                .assertThat()
                                .and().body(ROOT_JSON_PATH, Matchers.hasKey(KEY_STATUS_PATH))
                                .and().body(ROOT_JSON_PATH, Matchers.hasKey(KEY_EMPLOYEE_DATA))
                                .and().body(ROOT_JSON_PATH, Matchers.hasKey(KEY_MESSAGE_PATH))
                )
        );
        return true;
    }
}
