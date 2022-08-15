package com.restapiexample.dummy.stepdefinitions;

import io.cucumber.java.Before;
import lombok.Getter;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.actors.OnStage.*;

public class Hook {
    private EnvironmentVariables environmentVariables;

    @Getter
    private static String environmentBase;

    @Before
    public void initialConfiguration() {
        setTheStage(new OnlineCast());
        environmentBase = environmentVariables.optionalProperty("environments.qa.base.url").orElse("environments.dev.base.url");
    }
}
