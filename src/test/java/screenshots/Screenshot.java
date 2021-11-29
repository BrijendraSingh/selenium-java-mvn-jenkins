package screenshots;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;

public class Screenshot {

    @Attachment(value = "Juice shop screenshot", type = "image/png")
    public static ByteArrayInputStream capture(WebDriver driver){
        return new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
    }
}
