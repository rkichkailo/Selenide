package com.it_academy.onliner.api_tests;

import com.it_academy.onliner.BaseTest;
import com.it_academy.onliner.navigation.rest_api.service.SushiveslaService;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchingForSushiveslaTest extends BaseTest {

    @Test(groups = {"api"})
    @Description("Get Sushivesla objects and check data (id, key, name, full_name) for each")
    public void testSushiveslaEndpoint() {
        var sushi = new SushiveslaService().getSushiveslaItems();
        assertThat(sushi)
                .as("Not each Sushi object has a name")
                .isNotEmpty()
                .allMatch(sushivesla -> !sushivesla.getName().isBlank());
    }
}
