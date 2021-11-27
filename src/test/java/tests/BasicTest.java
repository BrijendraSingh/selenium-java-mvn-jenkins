package tests;

import org.testng.Assert;
import org.testng.annotations.*;
import setup.BaseTest;

import java.lang.reflect.Method;

public class BasicTest extends BaseTest {
    @Test
    public void verifyInvalidRegistration(Method m) {
        System.out.println("driver instance in Test <" + m +">" +  driver().toString());
        banner().dismissLandingBanner();
        navigation().openNewRegistrationForm();
        userCan().register();
        Assert.assertEquals(userCan().readUniqueUserError(UNIQUE_USER_ERROR), UNIQUE_USER_ERROR,"\"User with already used email can not be created\"");
    }

}
