package setup;

import factory.Browser;
import factory.BrowserFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pomodal.Banner;
import pomodal.Navigation;
import pomodal.Registration;

import java.time.Duration;

public class BaseTest {
//    protected WebDriver driver;
    ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    public final String UNIQUE_USER_ERROR = "Email must be unique";
    public final String UNIQUE_PASSWORD_ERROR = "Passwords do not match";

    @BeforeMethod
    public void setup(){
        threadDriver.set(BrowserFactory.getDriver(Browser.CHROME));

        threadDriver.get().get(Config.getConfig("DOCKER_URL"));
//        Dimension dim = new Dimension(800,600);
//        driver.manage().window().setSize(dim);
        threadDriver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("driver instance in Before each--> " +  threadDriver.get().toString());

    }

    public WebDriver driver(){
        Core.setDriver(threadDriver.get());
        return threadDriver.get();
    }

    public Registration userCan(){
       return new Registration();
    }

    public Banner banner(){
        return new Banner();
    }

    public Navigation navigation(){
        return new Navigation();
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("driver instance in After each--> " +  threadDriver.get().toString());
        threadDriver.get().quit();
        threadDriver.remove();
    }
}
