package tests;

import builder.Customer;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.*;
import setup.BaseTest;

import static io.qameta.allure.Allure.step;

public class OnlyVerifyPasswordTest extends BaseTest  {

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify Password Test")
    @Test
    public void verifyPasswordError()  {
        step("driver instance: " +  driver().toString());
        //create new customer data
        Customer customer = Customer.builder()
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
