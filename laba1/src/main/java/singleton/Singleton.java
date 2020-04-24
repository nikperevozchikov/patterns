package singleton;

import java.io.InputStream;
import java.util.Properties;

public class Singleton {

    private static Properties properties;
    private static Singleton instance;

    private Singleton() {
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties");
            properties = new Properties();
            properties.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static synchronized Properties getProperties() {
        if (instance == null) {
            instance = new Singleton();
        }
        return properties;
    }
//    public static synchronized String getProperty(String key) {
//        if (instance == null) {
//            instance = new Singleton();
//        }
//        return instance.getProperties().getProperty(key);
//    }

}

