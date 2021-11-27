package setup;

import org.awaitility.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Function;
import java.util.function.Predicate;

import static org.awaitility.Awaitility.await;

public class Core {
    public static WebDriver driver;
    public static void setDriver(WebDriver threadDriver){
        driver = threadDriver;
    }

    public void click(By by){
        findElementBeforeClick(by).click();
    }

    public void sendKeys(By by, String text){
        findElementBeforeSendKeys(by).sendKeys(text);
    }

    public String getText(By by){
        return findElementBeforeClick(by).getText();
    }

    public String getText(By by, String text){
        return findElementByText(by, text).getText();
    }

    Predicate<WebElement> isElementLocated = WebElement::isDisplayed;

    public WebElement findElement(By by){
        await().atMost(Duration.TEN_SECONDS)
                .pollInterval(Duration.ONE_HUNDRED_MILLISECONDS)
                .ignoreExceptions()
                .until(()-> isElementLocated.test(driver.findElement(by)));
        return driver.findElement(by);
    }

    public WebElement findElementBeforeClick(By by){
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(by));
        return driver.findElement(by);
    }

    public WebElement findElementBeforeSendKeys(By by){
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(15));
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        return driver.findElement(by);
    }

    public WebElement findElementByText(By by, String text){
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(15));
        wait.until(ExpectedConditions.textToBe(by, text));
        return driver.findElement(by);
    }

    public WebElement findElementWithFluentWait(By by){
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(java.time.Duration.ofSeconds(10))
                .pollingEvery(java.time.Duration.ofMillis(100))
                .ignoring(Exception.class);
        return  wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(by);
            }
        });
    }
}
