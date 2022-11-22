package com.it_academy.onliner.framework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class FirefoxDriverCreator implements WebDriverCreator{

    @Override
    public RemoteWebDriver create() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
}
