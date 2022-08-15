package com.restapiexample.dummy.stepdefinitions;

import com.restapiexample.dummy.exceptions.AssertionServicesError;
import com.restapiexample.dummy.questions.common.Schema;
import com.restapiexample.dummy.questions.common.StatusCodeResponse;
import com.restapiexample.dummy.questions.createemployee.FieldsResponseCreateEmployeeServiceAre;
import com.restapiexample.dummy.questions.createemployee.FieldsValuesResponseCreateEmployeeServiceAre;
import com.restapiexample.dummy.tasks.CreateEmployee;
import com.restapiexample.dummy.utils.resources.WebServicesEndPoints;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static com.restapiexample.dummy.exceptions.AssertionServicesError.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CreateEmployeeStepDefinition {
    @Given("^that (.*) wants to create a employee$")
    public void thatUserWantsToCreateAEmployee(String actor) {
        theActorCalled(actor).whoCan(CallAnApi.at(Hook.getEnvironmentBase()));
    }

    @When("he calls post create employee API service")
    public void heCallsPostCreateEmployeeAPIService() {
        theActorInTheSpotlight().attemptsTo(CreateEmployee.service(WebServicesEndPoints.URI_CREATE.getUrl()));
    }

    @Then("he validates status code create employee service is {int}")
    public void heValidatesStatusCodeCreateEmployeeServiceIs(Integer expectedStatusCode) {
        theActorInTheSpotlight().should(seeThat(StatusCodeResponse.is(expectedStatusCode)).orComplainWith(AssertionServicesError.class, STATUS_CODE_ERROR_MESSAGE));
    }

    @Then("he validates schema create employee response {string}")
    public void heValidatesSchemaCreateEmployeeResponse(String expectedSchemaCreateEmployee) {
        theActorInTheSpotlight().should(seeThat(Schema.is(expectedSchemaCreateEmployee)).orComplainWith(AssertionServicesError.class, SCHEMA_ERROR_MESSAGE));
    }

    @Then("he validates fields post create response employee api")
    public void heValidatesFieldsPostCreateResponseEmployeeApi() {
        theActorInTheSpotlight().should(seeThat(FieldsResponseCreateEmployeeServiceAre.expected()).orComplainWith(AssertionServicesError.class, FIELDS_ERROR_MESSAGE));
    }

    @Then("he validates fields values post create response employee api")
    public void heValidatesFieldsValuesPostCreateResponseEmployeeApi() {
        theActorInTheSpotlight().should(seeThat(FieldsValuesResponseCreateEmployeeServiceAre.expected()).orComplainWith(AssertionServicesError.class, FIELDS_ERROR_MESSAGE));
    }
}
