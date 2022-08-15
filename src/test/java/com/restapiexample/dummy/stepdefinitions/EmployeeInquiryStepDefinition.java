package com.restapiexample.dummy.stepdefinitions;

import com.restapiexample.dummy.exceptions.AssertionServicesError;
import com.restapiexample.dummy.questions.common.Schema;
import com.restapiexample.dummy.questions.common.StatusCodeResponse;
import com.restapiexample.dummy.questions.employeeinquiry.FieldsResponseEmployeeServiceAre;
import com.restapiexample.dummy.questions.employeeinquiry.FieldsValuesResponseGetEmployeeServiceAre;
import com.restapiexample.dummy.tasks.EmployeeInquiry;
import com.restapiexample.dummy.tasks.LoadEmployeeId;
import com.restapiexample.dummy.utils.resources.WebServicesEndPoints;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static com.restapiexample.dummy.exceptions.AssertionServicesError.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class EmployeeInquiryStepDefinition {

    @Given("^that (.*) wants to list employee information with id$")
    public void thatUserWantsToListEmployeeInformationWithId(String actor, DataTable data) {
        theActorCalled(actor).whoCan(CallAnApi.at(Hook.getEnvironmentBase()));
        theActorInTheSpotlight().attemptsTo(LoadEmployeeId.from(data.row(0).get(0)));
    }

    @When("he calls get employee API service")
    public void heCallsGetEmployeeAPIService() {
        theActorInTheSpotlight().attemptsTo(EmployeeInquiry.service(WebServicesEndPoints.URI_EMPLOYEE.getUrl()));
    }

    @Then("he validates status code get employee service is {int}")
    public void heValidatesStatusCodeGetEmployeeServiceIs(Integer expectedStatusCode) {
        theActorInTheSpotlight().should(seeThat(StatusCodeResponse.is(expectedStatusCode)).orComplainWith(AssertionServicesError.class, STATUS_CODE_ERROR_MESSAGE));
    }

    @Then("he validates schema employee response {string}")
    public void heValidatesSchemaEmployeeResponse(String expectedSchemaGetEmployee) {
        theActorInTheSpotlight().should(seeThat(Schema.is(expectedSchemaGetEmployee)).orComplainWith(AssertionServicesError.class, SCHEMA_ERROR_MESSAGE));
    }

    @Then("he validates fields get response employee api")
    public void heValidatesFieldsGetResponseEmployeeApi() {
        theActorInTheSpotlight().should(seeThat(FieldsResponseEmployeeServiceAre.expected()).orComplainWith(AssertionServicesError.class, FIELDS_ERROR_MESSAGE));
    }

    @Then("he validates fields values get response employee api")
    public void heValidatesFieldsValuesGetResponseEmployeeApi() {
        theActorInTheSpotlight().should(seeThat(FieldsValuesResponseGetEmployeeServiceAre.expected()).orComplainWith(AssertionServicesError.class, FIELDS_VALUES_ERROR_MESSAGE));
    }
}
