package pomodal;

import org.openqa.selenium.By;
import setup.Core;

public class Banner extends Core {
    By dismissBanner = By.cssSelector("button[aria-label='Close Welcome Banner']");

    public Banner dismissLandingBanner(){
        click(dismissBanner);
        return this;
    }
}
