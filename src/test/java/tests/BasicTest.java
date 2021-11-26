package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import setup.BaseTest;

import java.lang.reflect.Method;
import java.time.Duration;

public class BasicTest extends BaseTest implements  IBaseTest{
    @Test
    public void verifyInvalidRegistration(Method m) throws InterruptedException {
        System.out.println("driver instance in Test <" + m +">" +  driver.toString());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.findElement(dismissBanner).click();
        Thread.sleep(1500);

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

}
