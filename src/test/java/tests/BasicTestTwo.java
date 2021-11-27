package tests;

import builder.Customer;
import org.testng.Assert;
import org.testng.annotations.*;
import setup.BaseTest;

import java.lang.reflect.Method;

public class BasicTestTwo extends BaseTest  {

    @Test
    public void verifyPasswordError(Method m) throws InterruptedException {
        Thread.sleep(9000);
        System.out.println("driver instance in Test <" + m +">" +  driver().toString());
        //create new customer data
        Customer customer = new Customer.CustomerBuilder()
                .email("laverna.dubuque@hotmail.com")
                .password("abc123")
                .repeatPassword("abc1232")
                .maidenName("random text")
                .clickRegister(false)
                .build();

        banner().dismissLandingBanner();
        navigation().openNewRegistrationForm();
        userCan().register(customer);
        Assert.assertEquals(userCan().readRepeatPasswordError(), UNIQUE_PASSWORD_ERROR,"User should have same repeat password");
    }
}
