import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;

import java.util.ArrayList;
import java.util.Iterator;

import static org.testng.AssertJUnit.*;


public class SeleniumTest extends BaseTest{

    private Faker faker;
    private String email;
    private String password;
    private String country;
    private String name;
    private String mobileNumber;
    private String zipcode;
    private String address;
    private String city;
    private String state;
    private WebDriver driver;
    private MainPage mainPage;
    private ProductPage productPage;
    private SelectAddressPage selectAddressPage;
    private String appleJuiceText;
    private String greenSmoothieText;
    private String appleJuicePrice;
    private String greenSmoothiePrice;
    private final String USERNAME = "adellcomputer@gmail.com";
    private final String TESTPASSWORD = "1234567";
    private final String LOGINERRORMESSAGE = "Invalid email or password.";

    @BeforeClass
    public void setUpTests() {
        this.faker = new Faker();
        this.driver = driverManager.getDriver();
        this.email = this.faker.internet().emailAddress();
        this.password = this.faker.internet().password(8,12);
        this.country = this.faker.address().country();
        this.name = this.faker.name().fullName();
        this.mobileNumber = Integer.toString(this.faker.number().numberBetween(99900000, 99988888));
        this.zipcode = this.faker.number().digits(6);
        this.address = this.faker.address().streetAddress();
        this.city = this.faker.address().city();
        this.state = this.faker.address().state();
        this.mainPage = new MainPage(this.driver);
        this.productPage = new ProductPage(this.driver);
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
        boolean isValidLogin = true;
        loginPage.loginToPage(this.email,this.password, isValidLogin);
        assertTrue(this.mainPage.LogOutBtn().isDisplayed());
    }

    @Test(dependsOnMethods = "testLoginCredentials")
    public void testAddProductsToCart()  {
        this.productPage = new ProductPage(driver);
        this.productPage.addAppleJuiceToCart();
        this.appleJuiceText = this.productPage.getAppleJuiceText();
        this.appleJuicePrice = this.productPage.getAppleJuicePrice();
        assertEquals(
                productPage.getAddToCartSuccessMessageText(), "Placed Apple Juice (1000ml) into basket.");
        productPage.addGreenSmoothieToCart();
        this.greenSmoothieText = this.productPage.getGreenSmoothieText();
        this.greenSmoothiePrice = this.productPage.getGreenSmoothiePrice();
        assertEquals(
                productPage.getAddToCartSuccessMessageText(), "Placed Green Smoothie into basket.");
        assertEquals(
                productPage.getBasketCount(), "2");
    }

    @Test(dependsOnMethods = "testAddProductsToCart")
    public void testProductCheckout() {
        BasketPage basketPage = this.mainPage.clickSiteBasket();
        assertEquals(basketPage.getAppleJuiceText(), this.appleJuiceText);
        assertEquals(basketPage.getGreenSmoothieText(), this.greenSmoothieText);
        assertEquals(basketPage.getAppleJuicePrice(), this.appleJuicePrice);
        assertEquals(basketPage.getGreenSmoothiePrice(), this.greenSmoothiePrice);
        assertEquals(basketPage.getAppleJuiceQuantity(), "1");
        assertEquals(basketPage.getGreenSmoothieQuantity(), "1");
        assertEquals(basketPage.getBasketPageTotalPrice(), "Total Price: 3.98¤");

        this.selectAddressPage = basketPage.clickCheckOutLink();
    }

    @Test(dependsOnMethods = "testProductCheckout")
    public void testAddNewAddress() {
        CreateAddressPage createAddressPage = selectAddressPage.clickAddNewAddressBtn();
        createAddressPage.CreateNewAddress(this.country,
                this.name,
                this.mobileNumber,
                this.zipcode,
                this.address,
                this.city,
                this.state);
        assertEquals(createAddressPage.getSuccessMessage(), "The address at " + this.city + " has been successfully added to your addresses.");
    }

    @DataProvider
    public Iterator<Object[]> loginData() {
        ArrayList<Object[]> data = new ArrayList<>();
        data.add(new Object[] {USERNAME, "testing123", false});
        data.add(new Object[] {"testing123", TESTPASSWORD, false});
        data.add(new Object[] {"testing1234", "testing12345", false});
        data.add(new Object[] {USERNAME, TESTPASSWORD, true});

        return data.iterator();
    }

    @Test(dataProvider = "loginData")
    public void testMultipleLogins(String username, String password,Boolean isValidLogin) {
        LoginPage loginPage = this.mainPage.clickLogin();
        loginPage.loginToPage(username,password, isValidLogin);

        if (!isValidLogin) {
            assertEquals(loginPage.getErrorMessage(), LOGINERRORMESSAGE);
        } else {
            assertTrue(this.mainPage.LogOutBtn().isDisplayed());
            this.mainPage.LogOutBtn().click();
        }

    }

    @Test
    public void testUserNameNotValid() {
        LoginPage loginPage = this.mainPage.clickLogin();
        Boolean isValidLogin = false;
        loginPage.loginToPage("test123", TESTPASSWORD, isValidLogin);
        assertEquals(loginPage.getErrorMessage(), LOGINERRORMESSAGE);
    }

    @Test
    public void testPasswordNotValid() {
        LoginPage loginPage = this.mainPage.clickLogin();
        Boolean isValidLogin = false;
        loginPage.loginToPage(USERNAME, "test1234", isValidLogin);
        assertEquals(loginPage.getErrorMessage(), LOGINERRORMESSAGE);
    }

    @Test
    public void testInvalidLogin() {
        LoginPage loginPage = this.mainPage.clickLogin();
        Boolean isValidLogin = false;
        loginPage.loginToPage("USERNAME", "test1234", isValidLogin);
        assertEquals(loginPage.getErrorMessage(), LOGINERRORMESSAGE);
    }

}
