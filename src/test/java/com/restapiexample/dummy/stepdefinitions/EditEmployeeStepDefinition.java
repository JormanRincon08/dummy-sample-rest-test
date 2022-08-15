package com.restapiexample.dummy.stepdefinitions;

import com.restapiexample.dummy.exceptions.AssertionServicesError;
import com.restapiexample.dummy.questions.common.Schema;
import com.restapiexample.dummy.questions.common.StatusCodeResponse;
import com.restapiexample.dummy.questions.editemployee.FieldsResponseEditEmployeeServiceAre;
import com.restapiexample.dummy.questions.editemployee.FieldsValuesResponseEditEmployeeServiceAre;
import com.restapiexample.dummy.tasks.EditEmployee;
import com.restapiexample.dummy.tasks.LoadBodyData;
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

public class EditEmployeeStepDefinition {

    @Given("^that (.*) wants to edit information a employee with the following information$")
    public void thatUserWantsToEditInformationAEmployeeWithTheFollowingInformation(String actor, DataTable data) {
        theActorCalled(actor).whoCan(CallAnApi.at(Hook.getEnvironmentBase()));
        theActorInTheSpotlight().attemptsTo(LoadBodyData.employee(data.row(0)));
    }

    @When("he calls put edit employee API service")
    public void heCallsPutEditEmployeeAPIService() {
        theActorInTheSpotlight().attemptsTo(EditEmployee.service(WebServicesEndPoints.URI_UPDATE.getUrl()));
    }

    @Then("he validates status code edit employee service is {int}")
    public void heValidatesStatusCodeEditEmployeeServiceIs(Integer expectedStatusCode) {
        theActorInTheSpotlight().should(seeThat(StatusCodeResponse.is(expectedStatusCode)).orComplainWith(AssertionServicesError.class, STATUS_CODE_ERROR_MESSAGE));
    }

    @Then("he validates schema edit employee response {string}")
    public void heValidatesSchemaEditEmployeeResponse(String expectedSchemaEditEmployee) {
        theActorInTheSpotlight().should(seeThat(Schema.is(expectedSchemaEditEmployee)).orComplainWith(AssertionServicesError.class, SCHEMA_ERROR_MESSAGE));
    }

    @Then("he validates fields put edit response employee api")
    public void heValidatesFieldsPutEditResponseEmployeeApi() {
        theActorInTheSpotlight().should(seeThat(FieldsResponseEditEmployeeServiceAre.expected()).orComplainWith(AssertionServicesError.class, FIELDS_ERROR_MESSAGE));
    }

    @Then("he validates fields values put edit response employee api")
    public void heValidatesFieldsValuesPutEditResponseEmployeeApi() {
        theActorInTheSpotlight().should(seeThat(FieldsValuesResponseEditEmployeeServiceAre.expected()).orComplainWith(AssertionServicesError.class, FIELDS_VALUES_ERROR_MESSAGE));
    }
}
