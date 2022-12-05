package com.it_academy.onliner.api_tests;

import com.google.common.collect.ImmutableMap;
import com.it_academy.onliner.BaseTest;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import java.util.Map;

import static com.it_academy.onliner.navigation.rest_api.endpoints.OnlinerEndpoints.getSushiveslaEndPoint;
import static com.it_academy.onliner.navigation.rest_api.utils.GetRequestUtils.makeRequestAndGetResponse;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.everyItem;

public class SearchingForSushiveslaWithParamsTest extends BaseTest {
    @Test(groups = {"api"})
    @Description("Get filtered objects and check that all contain name_prefix in the response (\"Роллы\")")
    public void testSushiveslaEndpointWithParams() {

        Map<String, Object> filterParams = ImmutableMap.of(
                "sushi_typ[0]", "roll",
                "sushi_typ[operation]", "union");

        makeRequestAndGetResponse(getSushiveslaEndPoint(), null, filterParams)
                .then()
                .body("products.name_prefix", everyItem(equalToIgnoringCase("роллы")));
    }
}
