package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BrowserFactory {

    public static WebDriver getDriver(Browser browser){
        switch (browser){
            case CHROME:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            case REMOTE:
                try {
                    return new RemoteWebDriver(new URL("http://localhost:4444"), new ChromeOptions());
                } catch (MalformedURLException e) {
                    throw new Error("something wrong with remote driver setup");
                }
        }
        throw new Error("Browser Type <" + browser+ "> is not valid !!!");
    }
}
