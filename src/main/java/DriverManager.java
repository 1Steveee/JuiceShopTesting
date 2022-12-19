
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {

    //    set to private so no other class can access this variable
    //    this driver will be passed to other classes
    private WebDriver driver;

    public WebDriver getDriver() {
        /*
          returns instance of the driver variable without exposing it as public to other classes
        */
        return driver;
    }

    /*
    This method is responsible for creating a specific browser instance depending on the type of browser passed to it
    */
    public void startBrowser(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            createChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            createEdgeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            createFireFoxDriver();
        } else {
            System.out.println("Browser should either be chrome, edge, or firefox.");
        }
    }
    public void createEdgeDriver() {
        driver = new EdgeDriver();
    }
    public void createChromeDriver() {
        driver = new ChromeDriver();
    }

    public void createFireFoxDriver() {
        driver = new FirefoxDriver();
    }

    public void stopDriver() {
        driver.quit();
    }

}
