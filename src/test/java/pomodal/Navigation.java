package pomodal;

import org.openqa.selenium.By;
import setup.Core;

import static io.qameta.allure.Allure.step;
public class Navigation extends Core {
    //navigation
    By account_link = By.xpath("//span[text()=' Account ']");
    By login_link = By.id("navbarLoginButton");
    By newRegistration_link = By.cssSelector("#newCustomerLink a");

    public Navigation openNewRegistrationForm(){
        step("User Navigate to New Registration Screen");
        click(account_link);
        click(login_link);
        click(newRegistration_link);
        return this;
    }
}
