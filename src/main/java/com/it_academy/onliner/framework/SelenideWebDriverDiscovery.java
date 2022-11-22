package com.it_academy.onliner.framework;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;

public class SelenideWebDriverDiscovery implements WebDriverProvider {

    @Nonnull
    @Override
    public synchronized WebDriver createDriver(@Nonnull Capabilities capabilities) {
        String driverType = System.getProperty("driverType");
        try {
            return DriverCreatorFactory.getDriverCreator(driverType).create();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
