package com.it_academy.onliner.framework;

import static com.codeborne.selenide.Selenide.open;

public class BasePage {

    public BasePage(){
    }

    public void navigate(String url) {
        open(url);
    }
}
