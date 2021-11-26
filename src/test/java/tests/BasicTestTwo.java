package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import setup.BaseTest;

import java.lang.reflect.Method;
import java.time.Duration;

public class BasicTestTwo extends BaseTest implements IBaseTest  {

    @Test
    public void verifyPasswordError(Method m) throws InterruptedException {
        System.out.println("driver instance in Test <" + m +">" +  driver().toString());
        WebDriverWait wait = new WebDriverWait(driver(), Duration.ofSeconds(20));
        driver().findElement(dismissBanner).click();
        Thread.sleep(700);
        driver().findElement(account_link).click();
        driver().findElement(login_link).click();
        driver().findElement(newRegistration_link).click();

        //Registration form
        driver().findElement(email_textBox).sendKeys("laverna.dubuque@hotmail.com");
        driver().findElement(password_textBox).sendKeys("abc1234");
        driver().findElement(repeatPassword_textBox).sendKeys("abc12345");
        wait.until(ExpectedConditions.elementToBeClickable(securityQuestion_dropDown));
        driver().findElement(securityQuestion_dropDown).click();
        driver().findElement(securityOptionsMaindenName_options).click();
        driver().findElement(securityAnswer_textBox).sendKeys("laverna.dubuque@hotmail.com");
        driver().findElement(register_btn).click();

        //get error message
        String errorMsg = driver().findElement(uniqueRepeatPasswordError).getAttribute("innerText");
        Assert.assertEquals(errorMsg, UNIQUE_PASSWORD_ERROR, "User should have same repeat password");
    }
}
