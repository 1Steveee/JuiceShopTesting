import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;

import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;
import static utilities.Helper.takeScreenshot;

public class SeleniumTest extends BaseTest{

    private Faker faker;
    private String email;
    private String password;
    private WebDriver driver;
    private MainPage mainPage;

    @BeforeClass
    public void setUpTests() {
        this.faker = new Faker();
        this.driver = driverManager.getDriver();
        this.email = this.faker.internet().emailAddress();
        this.password = this.faker.internet().password(6,12);
        this.mainPage = new MainPage(this.driver);
    }

    @Test
    public void testUserRegistration() {
        this.mainPage.clickDismissBtn();
        LoginPage loginPage = this.mainPage.clickLogin();
        String notCustomerLinkText = "Not yet a customer?";
        assertEquals(notCustomerLinkText, loginPage.notaCustomerLinkText());
        RegisterPage registerPage = loginPage.clickNotCustomerLink();
        registerPage.login(this.email,this.password,"JaneDoe");
        String successMessage = "Registration completed successfully. You can now log in.";
        assertEquals(successMessage, registerPage.getSuccessMessage());
    }

    @Test
    public void testLoginCredentials() {
        LoginPage loginPage = this.mainPage.clickLogin();
        loginPage.loginToPage(this.email,this.password);
        assertTrue(this.mainPage.LogOutBtn().isDisplayed());
    }

}
