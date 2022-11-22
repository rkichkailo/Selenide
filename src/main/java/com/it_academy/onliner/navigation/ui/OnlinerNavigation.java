package com.it_academy.onliner.navigation.ui;

import com.it_academy.onliner.page_object.OnlinerHomePage;

public class OnlinerNavigation {

    public static void navigateToOnlinerHomePage() {
        new OnlinerHomePage().navigate("https://www.onliner.by/");
    }
}
