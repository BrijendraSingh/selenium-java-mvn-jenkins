package tests;

import builder.Customer;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.*;
import setup.BaseTest;

import static io.qameta.allure.Allure.step;

public class VerifyRegistrationFlow extends BaseTest {

    @Severity(SeverityLevel.TRIVIAL)
    @Description("Verify Registration Error")
    @Test
    public void verifyRegistrationError() {
        step("driver instance: " +  driver().toString());
        //Building customer test data
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

    @Severity(SeverityLevel.NORMAL)
    @Description("Verify Repeat Password Error")
    @Test
    public void verifyRepeatPasswordError(){
        step("driver instance: " +  driver().toString());
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
