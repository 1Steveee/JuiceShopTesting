import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
public class BaseTest {

    protected DriverManager driverManager;

    @Parameters("browser")
    @BeforeClass(alwaysRun = true)
    public void setupTest(String browser) {
        driverManager = new DriverManager();
        driverManager.startBrowser(browser);
        driverManager.getDriver().get("http://localhost:3000/#/");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driverManager.stopDriver();
    }
}
