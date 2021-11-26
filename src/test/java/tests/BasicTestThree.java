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

public class BasicTestThree implements IBaseTest {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(DOCKER_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void verifyInvalidRegistration(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.findElement(dismissBanner).click();

        driver.findElement(account_link).click();
        driver.findElement(login_link).click();
        driver.findElement(newRegistration_link).click();

        driver.findElement(email_textBox).sendKeys("laverna.dubuque@hotmail.com");
        driver.findElement(password_textBox).sendKeys("laverna.dubuque@hotmail.com");
        driver.findElement(repeatPassword_textBox).sendKeys("laverna.dubuque@hotmail.com");
        wait.until(ExpectedConditions.elementToBeClickable(securityQuestion_dropDown));
        driver.findElement(securityQuestion_dropDown).click();
        driver.findElement(securityOptionsMaindenName_options).click();
        driver.findElement(securityAnswer_textBox).sendKeys("laverna.dubuque@hotmail.com");
        driver.findElement(register_btn).click();


        wait.until(ExpectedConditions.textToBe(uniqueUserError_msg,UNIQUE_USER_ERROR));
        WebElement errorMsg = driver.findElement(uniqueUserError_msg);

        Assert.assertEquals(errorMsg.getText(), UNIQUE_USER_ERROR, "User with already used email can not be created");
    }

    @Test
    public void verifyPasswordError(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.findElement(dismissBanner).click();

        driver.findElement(account_link).click();
        driver.findElement(login_link).click();
        driver.findElement(newRegistration_link).click();


        driver.findElement(email_textBox).sendKeys("laverna.dubuque@hotmail.com");
        driver.findElement(password_textBox).sendKeys("abc1234");
        driver.findElement(repeatPassword_textBox).sendKeys("abc12345");
        wait.until(ExpectedConditions.elementToBeClickable(securityQuestion_dropDown));
        driver.findElement(securityQuestion_dropDown).click();
        driver.findElement(securityOptionsMaindenName_options).click();
        driver.findElement(securityAnswer_textBox).sendKeys("laverna.dubuque@hotmail.com");
        driver.findElement(register_btn).click();

        String errorMsg = driver.findElement(uniqueRepeatPasswordError).getAttribute("innerText");
        Assert.assertEquals(errorMsg, UNIQUE_PASSWORD_ERROR, "User should have same repeat password");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
