package com.restapiexample.dummy.stepdefinitions;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.actors.OnStage.*;

public class Hook {
    private final EnvironmentVariables environmentVariables;

    public Hook(EnvironmentVariables environmentVariables) {
        this.environmentVariables = environmentVariables;
    }

    @Before
    public void initialConfiguration() {
        setTheStage(new OnlineCast());
        theActorCalled("User");
        String restApiBaseUrl = environmentVariables.optionalProperty("environments.qa.base.url").orElse("environments.dev.base.url");
        theActorInTheSpotlight().whoCan(CallAnApi.at(restApiBaseUrl));
    }
}
