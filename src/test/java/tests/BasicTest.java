package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class BasicTest implements  IBaseTest{
    private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        WebDriver driverZero = new ChromeDriver();
        driver.set(driverZero);

        driver.get().get(DOCKER_URL);
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void verifyInvalidRegistration() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(20));

        driver.get().findElement(dismissBanner).click();
        Thread.sleep(1500);

        driver.get().findElement(account_link).click();
        driver.get().findElement(login_link).click();
        driver.get().findElement(newRegistration_link).click();

        driver.get().findElement(email_textBox).sendKeys("laverna.dubuque@hotmail.com");
        driver.get().findElement(password_textBox).sendKeys("laverna.dubuque@hotmail.com");
        driver.get().findElement(repeatPassword_textBox).sendKeys("laverna.dubuque@hotmail.com");

        wait.until(ExpectedConditions.elementToBeClickable(securityQuestion_dropDown));
        driver.get().findElement(securityQuestion_dropDown).click();
        driver.get().findElement(securityOptionsMaindenName_options).click();
        driver.get().findElement(securityAnswer_textBox).sendKeys("laverna.dubuque@hotmail.com");
        driver.get().findElement(register_btn).click();


        wait.until(ExpectedConditions.textToBe(uniqueUserError_msg,UNIQUE_USER_ERROR));
        WebElement errorMsg = driver.get().findElement(uniqueUserError_msg);

        Assert.assertEquals(errorMsg.getText(), UNIQUE_USER_ERROR, "User with already used email can not be created");
    }

    @AfterMethod
    public void tearDown(){
        driver.get().quit();
    }
}
