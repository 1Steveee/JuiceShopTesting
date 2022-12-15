import com.github.javafaker.Faker;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
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
        this.email = this.faker.internet().emailAddress();
        this.password = this.faker.internet().password(6,12);
    }

    @Test
    public void testRegisterPageChrome() {
        registerPage = new RegisterPage(driverManager.getDriver());
        registerPage.clickDismissBtn();
        registerPage
                .login(this.email,this.password,"JaneDoe");
        String successMessage = "Registration completed successfully. You can now log in.";
        assertEquals(successMessage, registerPage.getSuccessMessage());
    }

}
