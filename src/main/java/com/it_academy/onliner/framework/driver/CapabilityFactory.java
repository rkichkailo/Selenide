package com.it_academy.onliner.framework.driver;

import org.openqa.selenium.remote.DesiredCapabilities;

import static com.it_academy.onliner.framework.driver.OptionsManager.*;

public class CapabilityFactory {
    public static DesiredCapabilities capabilities;

    public static synchronized DesiredCapabilities getCapabilities(String browser) {
        switch (browser) {
            case "firefox" -> capabilities = getFirefoxDesiredCapabilities();
            case "edge" -> capabilities = getEdgeDesiredCapabilities();
            default -> capabilities = getChromeDesiredCapabilities();
        }
        return capabilities;
    }
}
