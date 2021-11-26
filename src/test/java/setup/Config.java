package setup;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public final class Config {
    public static Properties properties=null;
    public static Config config=null;

    private Config()  {
        properties = new Properties();
        FileInputStream file = null;
        try {
            file = new FileInputStream(System.getProperty("user.dir") + "/src/config.properties");
        } catch (FileNotFoundException e) {
            throw new Error("config file path is not valid -->" +System.getProperty("user.dir") + "/src/config.properties" );
        }
        try {
            properties.load(file);
        } catch (IOException e) {
            throw new Error("cant load properties file since its not a valid file");
        }
    }

    public static String getConfig(String key)  {
        if (config == null){
            config = new Config();
        }
        return properties.getProperty(key);
    }
}
