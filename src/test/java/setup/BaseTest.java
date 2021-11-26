package setup;

import factory.Browser;
import factory.BrowserFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver =BrowserFactory.getDriver(Browser.CHROME);

        driver.get(Config.getConfig("DEPLOYED_URL"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("driver instance in Before each--> " +  driver.toString());
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("driver instance in After each--> " +  driver.toString());
        driver.quit();
        driver=null;
    }
}
