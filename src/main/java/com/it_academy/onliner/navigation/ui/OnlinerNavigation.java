package com.it_academy.onliner.navigation.ui;

import com.it_academy.onliner.page_object.OnlinerHomePage;
import io.qameta.allure.Step;

public class OnlinerNavigation {

    @Step("Open Onliner url")
    public static void navigateToOnlinerHomePage() {
        new OnlinerHomePage().navigate("https://www.onliner.by/");
    }
}
