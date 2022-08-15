package com.restapiexample.dummy.interactions;

import io.restassured.http.ContentType;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.rest.interactions.Put;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class ExecutePut implements Interaction {

    private final String resource;
    private final String id;
    private final String body;

    public ExecutePut(String resource, String id, String body) {
        this.resource = resource;
        this.id = id;
        this.body = body;
    }

    @Step("{0} executes a PUT on the resource #resource")
    @Override
    public <T extends Actor> void performAs(T actor) {
        SerenityRest.reset();
        SerenityRest.useRelaxedHTTPSValidation();
        actor.attemptsTo(Put.to(resource)
                .with(request -> request
                        .contentType(ContentType.JSON)
                        .pathParam("id", id)
                        .body(body)
                        .log()
                        .all()
                )
        );
        lastResponse().peek();
    }

    public static PutServiceBuilder service(String resource) {
        return new PutServiceBuilder(resource);
    }

    public static class PutServiceBuilder {
        private final String resource;

        public PutServiceBuilder(String resource) {
            this.resource = resource;
        }

        public PutWithIdBuilder withId(String id) {
            return new PutWithIdBuilder(resource, id);
        }
    }


    public static class PutWithIdBuilder {
        private final String resource;
        private final String id;

        public PutWithIdBuilder(String resource, String id) {
            this.resource = resource;
            this.id = id;
        }

        public Performable andBody(String body) {
            return Instrumented.instanceOf(ExecutePut.class).withProperties(resource, id, body);
        }
    }

}
