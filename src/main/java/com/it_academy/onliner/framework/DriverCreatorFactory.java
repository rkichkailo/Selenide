package com.it_academy.onliner.framework;

import java.net.MalformedURLException;

public final class DriverCreatorFactory {

    private DriverCreatorFactory() {
    }

    public static synchronized WebDriverCreator getDriverCreator(String driverType) throws MalformedURLException {
        return switch (driverType) {
            case "firefox" -> new FirefoxDriverCreator();
            case "edge" -> new EdgeDriverCreator();
            default -> new ChromeDriverCreator();
        };
    }
}
