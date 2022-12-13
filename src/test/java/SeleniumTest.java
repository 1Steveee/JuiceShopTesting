import org.testng.annotations.Test;
import pages.RegisterPage;

import static org.testng.AssertJUnit.assertEquals;

public class SeleniumTest extends BaseTest{

    @Test
    public void testRegisterPageChrome() {
        RegisterPage registerPage = new RegisterPage(driverManager.getDriver());
        registerPage.clickDismissBtn();
        registerPage
                .login("manuel14444213@gmail.com","simpletest123","JaneDoe");
        String successMessage = "Registration completed successfully. You can now log in.";
        assertEquals(successMessage, registerPage.getSuccessMessage());
    }

}
