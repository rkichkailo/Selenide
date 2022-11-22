package com.it_academy.onliner.navigation.rest_api.endpoints;

import com.it_academy.onliner.navigation.rest_api.framework.PropertiesReader;

public class OnlinerEndpoints {

    public static String getSushiveslaEndPoint() {
        return PropertiesReader.getEndpointProperty("sushivesla");
    }
}
