package com.restapiexample.dummy.questions.createemployee;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.hamcrest.Matchers;

import static com.restapiexample.dummy.utils.constants.Manager.*;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class FieldsValuesResponseCreateEmployeeServiceAre implements Question<Boolean> {

    private FieldsValuesResponseCreateEmployeeServiceAre() {
    }

    public static FieldsValuesResponseCreateEmployeeServiceAre expected() {
        return new FieldsValuesResponseCreateEmployeeServiceAre();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.should(
                seeThatResponse("Validation fields values post employee service",
                        response -> response
                                .assertThat()
                                .and().body(ROOT_JSON_PATH, Matchers.hasKey(KEY_STATUS_PATH))
                                .and().body(KEY_STATUS_PATH, Matchers.equalTo(STATUS_SUCCESS_MESSAGE))
                                .and().body(ROOT_JSON_PATH, Matchers.hasKey(KEY_MESSAGE_PATH))
                                .and().body(KEY_MESSAGE_PATH, Matchers.equalTo(POST_SUCCESS_MESSAGE))
                )
        );
        return true;
    }
}
