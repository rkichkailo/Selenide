package com.it_academy.onliner.framework.driver;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

public class OptionsManager {
    public static DesiredCapabilities getChromeDesiredCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(Platform.WINDOWS);
        return capabilities;
    }

    public static DesiredCapabilities getFirefoxDesiredCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("firefox");
        capabilities.setPlatform(Platform.WINDOWS);
        return capabilities;
    }

    public static DesiredCapabilities getEdgeDesiredCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("MicrosoftEdge");
        capabilities.setPlatform(Platform.WINDOWS);
        return capabilities;
    }
}
