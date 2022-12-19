import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;

import static org.testng.AssertJUnit.assertEquals;

public class SeleniumTest extends BaseTest{

    private Faker faker;
    private String email;
    private String password;
    private RegisterPage registerPage;

    @BeforeClass
    public void setUpTests() {
        this.faker = new Faker();
    }

    @Test
    public void testRegisterPageChrome() {
        RegisterPage registerPage = new RegisterPage(driverManager.getDriver());
        registerPage.clickDismissBtn();
        this.email = this.faker.internet().emailAddress();
        this.password = this.faker.internet().password(6,12);
        registerPage.login(this.email,this.password,"JaneDoe");
        String successMessage = "Registration completed successfully. You can now log in.";
        assertEquals(successMessage, registerPage.getSuccessMessage());
    }

    @Test
    public void testMainPageLoginChrome() {
        MainPage mainPage = new MainPage(driverManager.getDriver());
        LoginPage loginPage = new LoginPage(driverManager.getDriver());
        RegisterPage registerPage = new RegisterPage(driverManager.getDriver());
        mainPage.clickDismissBtn();
        mainPage.clickLogin();
        String notCustomer = "Not yet a customer?";
        assertEquals(notCustomer, loginPage.notaCustomerLink().getText());
    }

}
