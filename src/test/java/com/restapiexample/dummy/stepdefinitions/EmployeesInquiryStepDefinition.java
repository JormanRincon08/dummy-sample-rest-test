package com.restapiexample.dummy.stepdefinitions;

import com.restapiexample.dummy.exceptions.AssertionServicesError;
import com.restapiexample.dummy.questions.employeesinquiry.FieldsResponseEmployeesServiceAre;
import com.restapiexample.dummy.questions.employeesinquiry.QuantityEmployees;
import com.restapiexample.dummy.questions.common.Schema;
import com.restapiexample.dummy.questions.common.StatusCodeResponse;
import com.restapiexample.dummy.tasks.EmployeesInquiry;
import com.restapiexample.dummy.utils.resources.WebServicesEndPoints;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static com.restapiexample.dummy.exceptions.AssertionServicesError.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class EmployeesInquiryStepDefinition {

    @Given("^that (.*) wants to list all employees$")
    public void thatUserWantsToListAllEmployees(String actor) {
        theActorCalled(actor).whoCan(CallAnApi.at(Hook.getEnvironmentBase()));
    }

    @When("he calls get employees API service")
    public void heCallsGetEmployeesAPIService() {
        theActorInTheSpotlight().attemptsTo(EmployeesInquiry.service(WebServicesEndPoints.URI_EMPLOYEES.getUrl()));
    }

    @Then("he validates status code get employees service is {int}")
    public void heValidatesStatusCodeGetEmployeesServiceIs(Integer expectedStatusCode) {
        theActorInTheSpotlight().should(seeThat(StatusCodeResponse.is(expectedStatusCode)).orComplainWith(AssertionServicesError.class, STATUS_CODE_ERROR_MESSAGE));
    }

    @Then("he validates quantity data employees is {int}")
    public void heValidatesQuantityDataEmployeesIs(Integer expectedNumberEmployees) {
        theActorInTheSpotlight().should(seeThat(QuantityEmployees.are(expectedNumberEmployees)).orComplainWith(AssertionServicesError.class, QUANTITY_DATA_ERROR_MESSAGE));
    }

    @Then("he validates schema employees response {string}")
    public void heValidatesSchemaEmployeesResponse(String expectedSchemaEmployees) {
        theActorInTheSpotlight().should(seeThat(Schema.is(expectedSchemaEmployees)).orComplainWith(AssertionServicesError.class, SCHEMA_ERROR_MESSAGE));
    }

    @Then("he validates fields get response employees api")
    public void heValidatesFieldsGetResponseEmployeesApi() {
        theActorInTheSpotlight().should(seeThat(FieldsResponseEmployeesServiceAre.expected()).orComplainWith(AssertionServicesError.class, FIELDS_ERROR_MESSAGE));
    }
}
