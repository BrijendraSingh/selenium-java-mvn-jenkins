package tests;

import builder.Customer;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.*;
import screenshots.Screenshot;
import setup.BaseTest;

import static io.qameta.allure.Allure.step;

public class OnlyValidRegistrationTest extends BaseTest {

    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify Invalid Registration flow")
    @Test(description = "TC-2000 ::: Search Wikipedia For Search Term")
    public void verifyInvalidRegistration() {
        step("driver instance: " +  driver().toString());
        //create new customer data
        Customer customer = Customer.builder()
                .email("laverna.dubuque@hotmail.com")
                .password("abc123")
                .repeatPassword("abc123")
                .maidenName("random text")
                .clickRegister(true)
                .build();

        banner().dismissLandingBanner();
        Allure.addAttachment("Demo Brij", Screenshot.capture(driver()));
        navigation().openNewRegistrationForm();
        userCan().register(customer);
        Assert.assertEquals(userCan().readUniqueUserError(UNIQUE_USER_ERROR), UNIQUE_USER_ERROR,"\"User with already used email can not be created\"");
    }

}
