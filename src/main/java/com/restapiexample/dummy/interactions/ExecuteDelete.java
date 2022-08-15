package com.restapiexample.dummy.interactions;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ExecuteDelete implements Interaction {

    private final String resource;
    private final String id;

    public ExecuteDelete(String resource, String id) {
        this.resource = resource;
        this.id = id;
    }

    @Step("{0} executes a GET on the resource #resource with id #id")
    @Override
    public <T extends Actor> void performAs(T actor) {
        SerenityRest.reset();
        SerenityRest.useRelaxedHTTPSValidation();
        actor.attemptsTo(Delete.from(resource)
                .with(request -> request
                        .contentType(ContentType.JSON)
                        .pathParam("id", id)
                        .log()
                        .all()
                )
        );
        lastResponse().peek();
    }

    public static DeleteServiceBuilder service(String resource) {
        return new DeleteServiceBuilder(resource);
    }

    public static class DeleteServiceBuilder {
        private final String resource;

        public DeleteServiceBuilder(String resource) {
            this.resource = resource;
        }

        public Performable withParameter(String id) {
            return instrumented(ExecuteDelete.class, resource, id);
        }
    }
}
