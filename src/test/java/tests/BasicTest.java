package tests;

import builder.Customer;
import org.testng.Assert;
import org.testng.annotations.*;
import setup.BaseTest;

import java.lang.reflect.Method;

public class BasicTest extends BaseTest {
    @Test
    public void verifyInvalidRegistration(Method m) {
        System.out.println("driver instance in Test <" + m +">" +  driver().toString());
        //create new customer data
        Customer customer = new Customer.CustomerBuilder()
                .email("laverna.dubuque@hotmail.com")
                .password("abc123")
                .repeatPassword("abc123")
                .maidenName("random text")
                .clickRegister(true)
                .build();

        banner().dismissLandingBanner();
        navigation().openNewRegistrationForm();
        userCan().register(customer);
        Assert.assertEquals(userCan().readUniqueUserError(UNIQUE_USER_ERROR), UNIQUE_USER_ERROR,"\"User with already used email can not be created\"");
    }

}
