package com.it_academy.onliner.navigation.rest_api.framework;

import com.it_academy.onliner.framework.driver.DriverManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

    private static final Logger LOG = LoggerFactory.getLogger(DriverManager.class);
    private static final String ENDPOINTS_FILE = "/endpoints.properties";
    private static final Properties ENDPOINTS_PROPERTIES = new Properties();
    static {
        initProperties();
    }
    public static String getEndpointProperty(String property) {
        return ENDPOINTS_PROPERTIES.getProperty(property);
    }

    private static synchronized void initProperties() {
        try (InputStream inputStream = PropertiesReader.class.getResourceAsStream(PropertiesReader.ENDPOINTS_FILE)) {
            PropertiesReader.ENDPOINTS_PROPERTIES.load(inputStream);
        } catch (IOException e) {
            LOG.error("File not found");
            throw new IllegalArgumentException("Unable to load properties from file: " + PropertiesReader.ENDPOINTS_FILE);
        }
    }
}
