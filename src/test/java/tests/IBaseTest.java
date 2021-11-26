package tests;

import org.openqa.selenium.By;

public interface IBaseTest {
    public final String UNIQUE_USER_ERROR = "Email must be unique";
    public final String UNIQUE_PASSWORD_ERROR = "Passwords do not match";
    public final String DOCKER_URL= "http://localhost:3000/#/";
    public final String DEPLOYED_URL= "https://juice-shop.herokuapp.com";

    By dismissBanner = By.cssSelector("button[aria-label='Close Welcome Banner']");

    //navigation
    By account_link = By.xpath("//span[text()=' Account ']");
    By login_link = By.id("navbarLoginButton");
    By newRegistration_link = By.cssSelector("#newCustomerLink a");

    //Registration
    By email_textBox = By.id("emailControl");
    By password_textBox = By.id("passwordControl");
    By repeatPassword_textBox = By.id("repeatPasswordControl");
    By securityQuestion_dropDown = By.xpath("//mat-select[@name='securityQuestion']/../..");
    By securityOptionsMaindenName_options = By.xpath("//span[@class='mat-option-text'][text()[contains(.,'maiden')]]");
    By securityAnswer_textBox = By.id("securityAnswerControl");
    By register_btn = By.id("registerButton");

    //get error message
    By uniqueUserError_msg = By.className("error");
    By uniqueRepeatPasswordError = By.cssSelector("mat-error.mat-error");
}
