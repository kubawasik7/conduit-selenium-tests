package data;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestDataReader {
    public static TestUser getTestUser() {
        Properties properties = loadProperties();

        String email = properties.getProperty("test.user.email");
        String password = properties.getProperty("test.user.password");

        return new TestUser(email, password);
    }

    public static TestUser getRegistrationUser() {
        Properties properties = loadProperties();

        String username = properties.getProperty("test.user.username");
        String email = properties.getProperty("test.user.email");
        String password = properties.getProperty("test.user.password");

        return new TestUser(username, email, password);
    }

    private static Properties loadProperties() {
        Properties properties = new Properties();

        InputStream inputStream = TestDataReader.class
                .getClassLoader()
                .getResourceAsStream("test-data.properties");

        if (inputStream == null) {
            throw new IllegalStateException("test-data.properties resource not found");
        }

        try {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new IllegalStateException("Failed to load test data", e);
        }

        return properties;
    }
}
