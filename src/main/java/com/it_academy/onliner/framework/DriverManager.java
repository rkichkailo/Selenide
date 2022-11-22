package com.it_academy.onliner.framework;

import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Selenide.open;
import static com.it_academy.onliner.framework.CapabilityFactory.getCapabilities;

public class DriverManager {

    public static synchronized void initDriver(String server, String driverType){
        switch (server){
            case "local" -> initLocalDriver(driverType);
            case "remote" -> initRemoteDriver(driverType);
            default -> System.out.println("No server provided");
        }
    }

    private static synchronized void initRemoteDriver(String driverType) {
        Configuration.remote = System.getProperty("remoteServer");
        Configuration.browserCapabilities = getCapabilities(driverType);
    }

    private static synchronized void initLocalDriver(String driverType) {
        setDriverTypeSystemProperty(driverType);
        Configuration.browser = SelenideWebDriverDiscovery.class.getName();
        Configuration.pageLoadTimeout = 200000;
        open();
    }

    private synchronized static void setDriverTypeSystemProperty(String driverType) {
        if (driverType != null){
            setNewDriverTypeProperty(driverType);
        }
    }

    private synchronized static void setNewDriverTypeProperty(String driverType) {
        System.setProperty("driverType", driverType);
    }
}
