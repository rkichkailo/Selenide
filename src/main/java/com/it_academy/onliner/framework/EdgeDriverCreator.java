package com.it_academy.onliner.framework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class EdgeDriverCreator implements WebDriverCreator{
    @Override
    public RemoteWebDriver create() {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }
}
