package tests;

import builder.Customer;
import org.testng.Assert;
import org.testng.annotations.*;
import setup.BaseTest;

import java.lang.reflect.Method;

public class BasicTestThree extends BaseTest {

    @Test
    public void verifyInvalidRegistration(Method m) throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("driver instance in Test <" + m +">" +  driver().toString());

        Customer customer = Customer.builder()
                .email("laverna.dubuque@hotmail.com")
                .password("abc123")
                .repeatPassword("abc123")
                .maidenName("random text")
                .clickRegister(true)
                .build();

        banner().dismissLandingBanner();
        navigation().openNewRegistrationForm();
        userCan().register(customer);
        Assert.assertEquals(userCan().readUniqueUserError(UNIQUE_USER_ERROR), UNIQUE_USER_ERROR,"User with already used email can not be created");
    }

    @Test
    public void verifyPasswordError(Method m) throws InterruptedException{
        Thread.sleep(6000);
        System.out.println("driver instance in Test <" + m +">" +  driver().toString());
        //create new customer data
        Customer customer = Customer.builder()
                .email("laverna.dubuque@hotmail.com")
                .password("abc123")
                .repeatPassword("abc1233")
                .maidenName("random text")
                .clickRegister(false)
                .build();

        banner().dismissLandingBanner();
        navigation().openNewRegistrationForm();
        userCan().register(customer);
        Assert.assertEquals(userCan().readRepeatPasswordError(), UNIQUE_PASSWORD_ERROR,"User should have same repeat password");
    }
}
