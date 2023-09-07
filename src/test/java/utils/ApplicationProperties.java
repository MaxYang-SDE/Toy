package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ApplicationProperties {
    private static final Properties properties;

    static {
        properties = new Properties();
        try (FileInputStream input = new FileInputStream("src/test/resources/application.properties")) {
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load application.properties file.", e);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}

