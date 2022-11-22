package com.it_academy.onliner.framework;

import org.openqa.selenium.remote.DesiredCapabilities;

import static com.it_academy.onliner.framework.OptionsManager.*;

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
