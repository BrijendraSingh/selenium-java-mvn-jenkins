package pomodal;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import screenshots.Screenshot;
import setup.Core;

import static io.qameta.allure.Allure.step;

public class Banner extends Core {
    By dismissBanner = By.cssSelector("button[aria-label='Close Welcome Banner']");

    public Banner dismissLandingBanner(){
        step("User Skip Notification Banner");
        Allure.addAttachment("Click on ", Screenshot.capture(driver));
        click(dismissBanner);
        return this;
    }
}
