import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;
import utilities.Helper;

import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;
import static utilities.Helper.takeScreenshot;

public class SeleniumTest extends BaseTest{

    private Faker faker;
    private String email;
    private String password;
    private RegisterPage registerPage;
    private WebDriver driver;


    @BeforeClass
    public void setUpTests() {
        this.faker = new Faker();
        this.driver = driverManager.getDriver();
    }

    @Test
    public void testRegisterPageChrome() {
        RegisterPage registerPage = new RegisterPage(this.driver);
        registerPage.clickDismissBtn();
        this.email = this.faker.internet().emailAddress();
        this.password = this.faker.internet().password(6,12);
        registerPage.login(this.email,this.password,"JaneDoe");
        String successMessage = "Registration completed successfully. You can now log in.";
        assertEquals(successMessage, registerPage.getSuccessMessage());
    }

    @Test
    public void testMainPageLoginChrome() throws IOException {
        MainPage mainPage = new MainPage(this.driver);
        LoginPage loginPage = new LoginPage(this.driver);
        RegisterPage registerPage = new RegisterPage(this.driver);
        mainPage.clickDismissBtn();
        mainPage.clickLogin();
        String notCustomerLinkText = "Not yet a customer?";
        assertEquals(notCustomerLinkText, loginPage.notaCustomerLinkText());
        loginPage.clickNotCustomerLink();
        takeScreenshot(this.driver);
    }

}
