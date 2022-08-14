package com.restapiexample.dummy.stepdefinitions;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.actors.OnStage.*;

public class Hook {
    private EnvironmentVariables environmentVariables;
    private static String environmentBase;


    @Before
    public void initialConfiguration() {
        setTheStage(new OnlineCast());
        environmentBase = environmentVariables.optionalProperty("environments.qa.base.url").orElse("environments.dev.base.url");
    }

    public static String getEnvironmentBase(){
        return environmentBase;
    }
}
