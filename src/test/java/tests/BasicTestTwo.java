package tests;

import org.testng.Assert;
import org.testng.annotations.*;
import setup.BaseTest;

import java.lang.reflect.Method;

public class BasicTestTwo extends BaseTest  {

    @Test
    public void verifyPasswordError(Method m) throws InterruptedException {
        Thread.sleep(9000);
        System.out.println("driver instance in Test <" + m +">" +  driver().toString());
        banner().dismissLandingBanner();
        navigation().openNewRegistrationForm();
        userCan().registerDifferentRepeatPassword();
        Assert.assertEquals(userCan().readRepeatPasswordError(), UNIQUE_PASSWORD_ERROR,"User should have same repeat password");
    }
}
