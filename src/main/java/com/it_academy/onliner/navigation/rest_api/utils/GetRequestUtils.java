package com.it_academy.onliner.navigation.rest_api.utils;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.apache.commons.collections4.MapUtils;
import org.apache.hc.core5.http.HttpStatus;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetRequestUtils {

    public static ResponseBody makeRequestAndGetResponseBody(String endpoint,
                                                             Map<String, Object> headers,
                                                             Map<String, Object> params
    ) {
        return given()
                .headers(MapUtils.emptyIfNull(headers))
                .params(MapUtils.emptyIfNull(params))
                .when()
                .get(endpoint)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response()
                .getBody();
    }

    public static Response makeRequestAndGetResponse(String endpoint,
                                                     Map<String, Object> headers,
                                                     Map<String, Object> params
    ) {
        return given()
                .headers(MapUtils.emptyIfNull(headers))
                .params(MapUtils.emptyIfNull(params))
                .when()
                .get(endpoint)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();
    }
}
