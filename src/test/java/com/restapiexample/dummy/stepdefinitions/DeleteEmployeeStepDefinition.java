package com.restapiexample.dummy.stepdefinitions;

import com.restapiexample.dummy.exceptions.AssertionServicesError;
import com.restapiexample.dummy.questions.common.Schema;
import com.restapiexample.dummy.questions.common.StatusCodeResponse;
import com.restapiexample.dummy.questions.deleteemployee.FieldsResponseDeleteEmployeeServiceAre;
import com.restapiexample.dummy.questions.deleteemployee.FieldsValuesResponseDeleteEmployeeServiceAre;
import com.restapiexample.dummy.questions.employeeinquiry.FieldsResponseEmployeeServiceAre;
import com.restapiexample.dummy.questions.employeeinquiry.FieldsValuesResponseGetEmployeeServiceAre;
import com.restapiexample.dummy.tasks.DeleteEmployee;
import com.restapiexample.dummy.tasks.LoadEmployeeId;
import com.restapiexample.dummy.utils.resources.WebServicesEndPoints;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static com.restapiexample.dummy.exceptions.AssertionServicesError.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class DeleteEmployeeStepDefinition {
    @Given("that {string} wants to delete employee information by id {string}")
    public void thatUserWantsToDeleteEmployeeInformationById(String actor, String id) {
        theActorCalled(actor).whoCan(CallAnApi.at(Hook.getEnvironmentBase()));
        theActorInTheSpotlight().attemptsTo(LoadEmployeeId.from(id));
    }

    @When("he calls delete employee API service")
    public void heCallsDeleteEmployeeAPIService() {
        theActorInTheSpotlight().attemptsTo(DeleteEmployee.service(WebServicesEndPoints.URI_DELETE.getUrl()));
    }

    @Then("he validates status code delete employee service is {int}")
    public void heValidatesStatusCodeDeleteEmployeeServiceIs(Integer expectedStatusCode) {
        theActorInTheSpotlight().should(seeThat(StatusCodeResponse.is(expectedStatusCode)).orComplainWith(AssertionServicesError.class, STATUS_CODE_ERROR_MESSAGE));
    }

    @Then("he validates schema delete employee response {string}")
    public void heValidatesSchemaDeleteEmployeeResponse(String expectedSchemaDeleteEmployee) {
        theActorInTheSpotlight().should(seeThat(Schema.is(expectedSchemaDeleteEmployee)).orComplainWith(AssertionServicesError.class, SCHEMA_ERROR_MESSAGE));
    }

    @Then("he validates fields delete response employee api")
    public void heValidatesFieldsDeleteResponseEmployeeApi() {
        theActorInTheSpotlight().should(seeThat(FieldsResponseDeleteEmployeeServiceAre.expected()).orComplainWith(AssertionServicesError.class, FIELDS_ERROR_MESSAGE));
    }

    @Then("he validates fields values delete response employee api")
    public void heValidatesFieldsValuesDeleteResponseEmployeeApi() {
        theActorInTheSpotlight().should(seeThat(FieldsValuesResponseDeleteEmployeeServiceAre.expected()).orComplainWith(AssertionServicesError.class, FIELDS_VALUES_ERROR_MESSAGE));
    }
}
