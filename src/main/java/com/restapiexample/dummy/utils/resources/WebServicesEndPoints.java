package com.restapiexample.dummy.utils.resources;

import com.restapiexample.dummy.utils.constants.Endpoints;

public enum WebServicesEndPoints {

    URI_EMPLOYEES(Endpoints.URL_EMPLOYEES),
    URI_EMPLOYEE(Endpoints.URL_EMPLOYEE),
    URI_CREATE(Endpoints.URL_CREATE),
    URI_UPDATE(Endpoints.URL_UPDATE),
    URI_DELETE(Endpoints.URL_DELETE);

    private final String url;

    WebServicesEndPoints(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

}
