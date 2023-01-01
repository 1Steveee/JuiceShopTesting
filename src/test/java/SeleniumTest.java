import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.ProductPage;
import pages.RegisterPage;
import utilities.Helper;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;


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
        this.password = this.faker.internet().password(8,12);
        this.mainPage = new MainPage(this.driver);
    }

    @Test
    public void testUserRegistration() {
        String successMessage = "Registration completed successfully. You can now log in.";
        String notCustomerLinkText = "Not yet a customer?";

        LoginPage loginPage = this.mainPage.clickLogin();
        assertEquals(notCustomerLinkText, loginPage.notaCustomerLinkText());
        RegisterPage registerPage = loginPage.clickNotCustomerLink();
        registerPage.login(this.email,this.password,"JaneDoe");
        assertEquals(successMessage, registerPage.getSuccessMessage());
    }

    @Test
    public void testLoginCredentials() {
        LoginPage loginPage = this.mainPage.clickLogin();
        loginPage.loginToPage(this.email,this.password);
        assertTrue(this.mainPage.LogOutBtn().isDisplayed());
    }

    @Test(dependsOnMethods = "testLoginCredentials")
    public void testAddProductsToCart() throws InterruptedException {
        ProductPage productPage = new ProductPage(driver);
        productPage.addAppleJuiceToCart();
        assertEquals(
                productPage.getAddToCartSuccessMessageText(), "Placed Apple Juice (1000ml) into basket.");
        productPage.addGreenSmoothieToCart();
        assertEquals(
                productPage.getAddToCartSuccessMessageText(), "Placed Green Smoothie into basket.");
        assertEquals(
                productPage.getWarningNotificationText(), "2");
    }


}
