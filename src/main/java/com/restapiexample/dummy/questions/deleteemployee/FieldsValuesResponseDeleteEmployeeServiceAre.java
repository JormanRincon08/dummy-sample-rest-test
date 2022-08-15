package com.restapiexample.dummy.questions.deleteemployee;

import com.restapiexample.dummy.models.CurrentEmployee;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.hamcrest.Matchers;

import static com.restapiexample.dummy.utils.constants.Manager.*;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class FieldsValuesResponseDeleteEmployeeServiceAre implements Question<Boolean> {

    private FieldsValuesResponseDeleteEmployeeServiceAre() {
    }

    public static FieldsValuesResponseDeleteEmployeeServiceAre expected() {
        return new FieldsValuesResponseDeleteEmployeeServiceAre();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.should(
                seeThatResponse("Validation fields delete post employee service",
                        response -> response
                                .assertThat()
                                .and().body(KEY_STATUS_PATH, Matchers.equalTo(STATUS_SUCCESS_MESSAGE))
                                .and().body(KEY_EMPLOYEE_DATA, Matchers.equalTo(CurrentEmployee.getEmployeeId()))
                                .and().body(KEY_MESSAGE_PATH, Matchers.equalTo(DELETE_SUCCESS_MESSAGE))
                )
        );
        return true;
    }
}
