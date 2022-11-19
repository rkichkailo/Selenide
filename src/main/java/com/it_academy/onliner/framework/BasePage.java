package com.it_academy.onliner.framework;

import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Selenide.open;

public class BasePage {

    public BasePage(){
        Configuration.browser = "Chrome";
        Configuration.pageLoadTimeout = 20000;
    }

    public void navigate(String url) {
        open(url);
    }
}
