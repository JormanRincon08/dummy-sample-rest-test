package com.restapiexample.dummy.questions.employeeinquiry;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.hamcrest.Matchers;

import static com.restapiexample.dummy.utils.constants.Manager.*;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class FieldsValuesResponseGetEmployeeServiceAre implements Question<Boolean> {

    private FieldsValuesResponseGetEmployeeServiceAre() {
    }

    public static FieldsValuesResponseGetEmployeeServiceAre expected() {
        return new FieldsValuesResponseGetEmployeeServiceAre();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String keyMapFormat = "%s.%s";
        actor.should(
                seeThatResponse("Validation fields values get employee service",
                        response -> response
                                .assertThat()
                                .and().body(KEY_STATUS_PATH, Matchers.equalTo(STATUS_SUCCESS_MESSAGE))
                                .and().body(KEY_MESSAGE_PATH, Matchers.equalTo(GET_SUCCESS_MESSAGE))
                                .and().body(String.format(keyMapFormat, KEY_EMPLOYEE_DATA, KEY_ID_EMPLOYEE), Matchers.equalTo(21))
                                .and().body(String.format(keyMapFormat, KEY_EMPLOYEE_DATA, KEY_EMPLOYEES_NAME), Matchers.equalTo("Jenette Caldwell"))
                                .and().body(String.format(keyMapFormat, KEY_EMPLOYEE_DATA, KEY_EMPLOYEES_SALARY), Matchers.equalTo(345000))
                                .and().body(String.format(keyMapFormat, KEY_EMPLOYEE_DATA, KEY_EMPLOYEES_AGE), Matchers.equalTo(30))
                                .and().body(String.format(keyMapFormat, KEY_EMPLOYEE_DATA, KEY_PROFILE_IMAGE), Matchers.equalTo(""))
                )
        );
        return true;
    }
}
