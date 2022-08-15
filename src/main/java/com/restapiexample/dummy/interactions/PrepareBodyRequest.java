package com.restapiexample.dummy.interactions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PrepareBodyRequest implements Interaction {
    private static final Logger LOGGER = LoggerFactory.getLogger(PrepareBodyRequest.class);
    private final String jsonName;
    private final List<String> jsonData;

    public PrepareBodyRequest(String name, List<String> data) {
        this.jsonName = name;
        this.jsonData = data;
    }

    public static PrepareBodyRequest with(String name, List<String> data) {
        return instrumented(PrepareBodyRequest.class, name, data);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String request = getJsonFile(jsonName);
        request = jsonPreparedData(request, jsonData);
        Serenity.setSessionVariable("Request").to(request);
    }

    private String getJsonFile(String jsonFile) {
        String data = "";
        File file = new File(Objects.requireNonNull(PrepareBodyRequest.class.getClassLoader().getResource(jsonFile)).getPath().replace("%20", " "));
        try {
            data = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return data;
    }

    public static String jsonPreparedData(String json, List<String> data) {
        return String.format(json, data.toArray());
    }
}
