package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SelectAddressPage {

    private WebDriver driver;

    public SelectAddressPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement addNewAddressBtn() {
        return driver.findElement(By.cssSelector("app-address > mat-card > div > button"));
    }

    public CreateAddressPage clickAddNewAddressBtn() {
        addNewAddressBtn().click();
        return new CreateAddressPage(driver);
    }
}
