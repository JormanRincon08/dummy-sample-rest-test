package com.restapiexample.dummy.questions.editemployee;

import com.restapiexample.dummy.models.CurrentEmployee;
import io.restassured.path.json.JsonPath;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.restapiexample.dummy.utils.constants.Manager.*;
import static com.restapiexample.dummy.utils.resources.ValidatorManager.*;
import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class FieldsValuesResponseEditEmployeeServiceAre implements Question<Boolean> {

    private static final Logger LOGGER = LoggerFactory.getLogger(FieldsValuesResponseEditEmployeeServiceAre.class);

    private FieldsValuesResponseEditEmployeeServiceAre() {
    }

    public static FieldsValuesResponseEditEmployeeServiceAre expected() {
        return new FieldsValuesResponseEditEmployeeServiceAre();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        Boolean isSuccess = false;
        try {
            isSuccess = verifyDataResponse();
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return isSuccess;
    }

    private Boolean verifyDataResponse() {
        String responseService = lastResponse().getBody().asString();
        JsonPath jsonPathResponse = new JsonPath(responseService);

        Map<String, Object> expected = CurrentEmployee.getEmployeeMapData();
        Map<String, Object> found = getFound(jsonPathResponse);

        List<Boolean> verifications = new ArrayList<>();
        verifications.add(compareDifferences(STATUS_SUCCESS_MESSAGE, jsonPathResponse.getString(KEY_STATUS_PATH), "Status"));
        verifications.add(compareDifferences(PUT_SUCCESS_MESSAGE, jsonPathResponse.getString(KEY_MESSAGE_PATH), "Message"));
        verifications.add(compareDifferences(expected.get(KEY_EMPLOYEE_NAME), found.get(KEY_EMPLOYEE_NAME), "Employee name"));
        verifications.add(compareDifferences(expected.get(KEY_EMPLOYEE_SALARY), found.get(KEY_EMPLOYEE_SALARY), "Employee salary"));
        verifications.add(compareDifferences(expected.get(KEY_EMPLOYEE_AGE), found.get(KEY_EMPLOYEE_AGE), "Employee age"));
        verifications.add(compareDifferences(expected.get(KEY_PROFILE_IMAGE), found.get(KEY_PROFILE_IMAGE), "Profile image"));
        generatedReport(REPORT_TITLE_PUT_SERVICE);
        return isFalse(verifications);
    }

    private Map<String, Object> getFound(JsonPath jsonPath) {
        return jsonPath.getMap(KEY_EMPLOYEE_DATA);
    }
}
