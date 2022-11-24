package com.it_academy.onliner.framework.driver;

import com.codeborne.selenide.Configuration;

import java.util.Objects;

import static com.it_academy.onliner.framework.driver.CapabilityFactory.getCapabilities;

public class DriverFactory {
    private static final String DEFAULT_BROWSER_TYPE = "chrome";

    public static synchronized void selectBrowserForDriver(String driverType) {
        setBrowser(Objects.requireNonNullElse(driverType, DEFAULT_BROWSER_TYPE));
    }

    private static synchronized void setBrowser(String browser){
        Configuration.browser = browser;
        Configuration.timeout = 20000;
    }

    public static synchronized void setRemoteDriver(String driverType){
        Configuration.remote = System.getProperty("remoteServer");
        selectBrowserForDriver(driverType);
        Configuration.browserCapabilities = getCapabilities(driverType);
    }
}
