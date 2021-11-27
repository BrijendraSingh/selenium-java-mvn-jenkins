package tests;

import org.testng.Assert;
import org.testng.annotations.*;
import setup.BaseTest;

import java.lang.reflect.Method;

public class BasicTestThree extends BaseTest {

    @Test
    public void verifyInvalidRegistration(Method m) throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("driver instance in Test <" + m +">" +  driver().toString());
        banner().dismissLandingBanner();
        navigation().openNewRegistrationForm();
        userCan().register();
        Assert.assertEquals(userCan().readUniqueUserError(UNIQUE_USER_ERROR), UNIQUE_USER_ERROR,"User with already used email can not be created");
    }

    @Test
    public void verifyPasswordError(Method m) throws InterruptedException{
        Thread.sleep(6000);
        System.out.println("driver instance in Test <" + m +">" +  driver().toString());
        banner().dismissLandingBanner();
        navigation().openNewRegistrationForm();
        userCan().registerDifferentRepeatPassword();
        Assert.assertEquals(userCan().readRepeatPasswordError(), UNIQUE_PASSWORD_ERROR,"User should have same repeat password");
    }
}
