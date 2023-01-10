import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import pages.MainPage;

public class BaseTest {

    protected DriverManager driverManager;

    @Parameters("browser")
    @BeforeClass(alwaysRun = true)
    public void setupTest(String browser) {
        driverManager = new DriverManager();
        driverManager.startBrowser(browser);
        driverManager.getDriver().get("http://localhost:3000");
        MainPage mainPage = new MainPage(driverManager.getDriver());
        mainPage.clickDismissBtn();
        mainPage.clickMeWantItLink();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driverManager.stopDriver();
    }
}
