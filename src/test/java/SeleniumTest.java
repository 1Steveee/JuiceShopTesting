import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.RegisterPage;

public class SeleniumTest extends BaseTest{



    @Test
    public void testRegisterPageChrome() {
        RegisterPage registerPage = new RegisterPage(driverManager.getDriver());

        registerPage.dismissBtn();
        registerPage
                .login("manuel123@gmail.com","simpletest123",
                        "simpletest123","JaneDoe");

    }

}
