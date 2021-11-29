package pomodal;

import builder.Customer;
import org.openqa.selenium.By;
import setup.Core;

import static io.qameta.allure.Allure.step;

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

    public Registration register(Customer customer){
        step("User complete the customer registration with data: " + customer.toString());
        sendKeys(email_textBox, customer.getEmail());
        sendKeys(password_textBox, customer.getPassword());
        sendKeys(repeatPassword_textBox, customer.getRepeatPassword());

        click(securityQuestion_dropDown);
        click(securityOptionsMaidenName_options);
        sendKeys(securityAnswer_textBox, customer.getMaidenName());
        if (customer.isClickRegister()) {
            step("User clicks the Registration Button");
            click(register_btn);
        }
        return this;
    }

    public String readUniqueUserError(String errorText){
        step("User read the Unique User Error Message:" + errorText);
        return getText(uniqueUserError_msg, errorText);
    }

    public String readRepeatPasswordError(){
        step("User read the repeat password Error Message");
        return getText(uniqueRepeatPasswordError);
    }
}
