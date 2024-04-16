package com.kinandcarta.poc;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;


public class ConfigurationLoader {

    private static Logger LOGGER = Logger.getLogger(ConfigurationLoader.class.getName());

    public static Properties getConfig() {
        Properties properties = new Properties();
        String filename = "src/main/resources/application.properties";
        try {
            properties.load(new FileInputStream(filename));
            return properties;
        } catch (IOException e) {
            LOGGER.severe("Unable to load properties file: " + filename);
            throw new RuntimeException(e);
        }
    }
}
