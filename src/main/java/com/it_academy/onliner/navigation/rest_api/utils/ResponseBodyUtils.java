package com.it_academy.onliner.navigation.rest_api.utils;

import io.restassured.response.ResponseBody;

import java.util.List;

public class ResponseBodyUtils {

    public static <T> List<T> getObjectsByJsonPath(
            ResponseBody responseBody, String jsonPath, Class<T> type) {
        return responseBody
                .jsonPath()
                .getList(jsonPath, type);
    }
}
