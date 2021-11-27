package pomodal;

import org.openqa.selenium.By;
import setup.Core;

public class Registration extends Core {
    //Registration fields
    By email_textBox = By.id("emailControl");
    By password_textBox = By.id("passwordControl");
    By repeatPassword_textBox = By.id("repeatPasswordControl");
    By securityQuestion_dropDown = By.xpath("//mat-select[@name='securityQuestion']/../..");
    By securityOptionsMaidenName_options = By.xpath("//span[@class='mat-option-text'][text()[contains(.,'maiden')]]");
    By securityAnswer_textBox = By.id("securityAnswerControl");
    By register_btn = By.id("registerButton");

    //get error message
    By uniqueUserError_msg = By.className("error");
    By uniqueRepeatPasswordError = By.cssSelector("mat-error.mat-error");

    public Registration register(){
        sendKeys(email_textBox, "laverna.dubuque@hotmail.com");
        sendKeys(password_textBox, "abc1234");
        sendKeys(repeatPassword_textBox, "abc1234");

        click(securityQuestion_dropDown);
        click(securityOptionsMaidenName_options);
        sendKeys(securityAnswer_textBox, "randomText");
        click(register_btn);
        return this;
    }

    public Registration registerDifferentRepeatPassword(){
        sendKeys(email_textBox, "laverna.dubuque@hotmail.com");
        sendKeys(password_textBox, "abc1234");
        sendKeys(repeatPassword_textBox, "abc12345");

        click(securityQuestion_dropDown);
        click(securityOptionsMaidenName_options);
        sendKeys(securityAnswer_textBox, "randomText");
        return this;
    }

    public String readUniqueUserError(String errorText){
        return getText(uniqueUserError_msg, errorText);
    }

    public String readRepeatPasswordError(){
        return getText(uniqueRepeatPasswordError);
    }

}
