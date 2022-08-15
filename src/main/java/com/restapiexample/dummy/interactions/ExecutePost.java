package com.restapiexample.dummy.interactions;

import com.restapiexample.dummy.models.EmployeeModel;
import io.restassured.http.ContentType;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class ExecutePost implements Interaction {

    private final String resource;
    private final EmployeeModel body;

    public ExecutePost(String resource, EmployeeModel body) {
        this.resource = resource;
        this.body = body;
    }

    @Step("{0} executes a POST on the resource #resource")
    @Override
    public <T extends Actor> void performAs(T actor) {
        SerenityRest.reset();
        SerenityRest.useRelaxedHTTPSValidation();
        actor.attemptsTo(Post.to(resource)
                .with(request -> request
                        .contentType(ContentType.JSON)
                        .body(body)
                        .log()
                        .all()
                )
        );
        lastResponse().peek();
    }

    public static PostServiceBuilder service(String resource) {
        return new PostServiceBuilder(resource);
    }

    public static class PostServiceBuilder {
        private final String resource;

        public PostServiceBuilder(String resource) {
            this.resource = resource;
        }

        public Performable withBody(EmployeeModel body) {
            return Instrumented.instanceOf(ExecutePost.class).withProperties(resource, body);
        }
    }
}
