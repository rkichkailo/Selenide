package com.it_academy.onliner.navigation.rest_api.service;

import com.it_academy.onliner.navigation.rest_api.model.Sushivesla;
import io.restassured.response.ResponseBody;

import java.util.List;

import static com.it_academy.onliner.navigation.rest_api.endpoints.OnlinerEndpoints.getSushiveslaEndPoint;
import static com.it_academy.onliner.navigation.rest_api.utils.GetRequestUtils.makeRequestAndGetResponseBody;
import static com.it_academy.onliner.navigation.rest_api.utils.ResponseBodyUtils.getObjectsByJsonPath;

public class SushiveslaService {

    private static final String SUSHIVESLA_JSON_PATH = "products";

    public List<Sushivesla> getSushiveslaItems(){
        ResponseBody responseBody =
                makeRequestAndGetResponseBody(getSushiveslaEndPoint(), null, null);
        return getObjectsByJsonPath(responseBody, SUSHIVESLA_JSON_PATH, Sushivesla.class);
    }
}
