package setup;

import factory.Browser;
import factory.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pomodal.Banner;
import pomodal.Navigation;
import pomodal.Registration;

import java.time.Duration;

import static io.qameta.allure.Allure.step;

public class BaseTest{
    ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    public final String UNIQUE_USER_ERROR = "Email must be unique";
    public final String UNIQUE_PASSWORD_ERROR = "Passwords do not match";

    @BeforeMethod
    public void setup(){
        step(Browser.CHROME + " : Browser Is Instantiated");
        threadDriver.set(BrowserFactory.getDriver(Browser.CHROME));
        threadDriver.get().get(Config.getConfig("DOCKER_URL"));
        step(Config.getConfig("DOCKER_URL")+ " : Application URL Is launched");
        threadDriver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        step("driver instance: " +  threadDriver.get().toString());
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
        step("driver instance: " +  threadDriver.get().toString());
        threadDriver.get().quit();
        threadDriver.remove();
        step("driver is closed");
    }
}
