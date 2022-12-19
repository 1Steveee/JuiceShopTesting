import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
public class BaseTest {

    /*
    Add comments
     */
    public DriverManager driverManager;

    @Parameters("browser")
    @BeforeClass(alwaysRun = true)
    public void setupTest(String browser) {
        driverManager = new DriverManager();
        driverManager.startBrowser(browser);
        driverManager.getDriver().get("https://juice-shop.herokuapp.com");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driverManager.stopDriver();
    }
}
