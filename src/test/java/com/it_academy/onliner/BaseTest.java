package com.it_academy.onliner;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.it_academy.onliner.listener.AllureListener;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;


@Listeners(AllureListener.class)
public class BaseTest {

    @BeforeClass
    public void setupListeners(){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true));
    }
}
