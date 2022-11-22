package com.it_academy.onliner.framework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ChromeDriverCreator implements WebDriverCreator<RemoteWebDriver> {

    @Override
    public RemoteWebDriver create() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}
