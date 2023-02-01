package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CreateAddressPage {

    private WebDriver driver;

    public CreateAddressPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement successMessage() {
        return driver.findElement(By.cssSelector(".mat-simple-snack-bar-content"));
    }

    private List<WebElement> formFields() {
        return driver.findElements(By.cssSelector("#address-form input"));
    }

    private WebElement countryField() {
        return formFields().get(0);
    }

    private WebElement nameField() {
        return formFields().get(1);
    }

    private WebElement mobileNumberField() {
        return  formFields().get(2);
    }

    private WebElement zipcodeField() {
        return formFields().get(3);
    }

    private WebElement addressField() {
        return driver.findElement(By.id("address"));
    }

    private WebElement cityField() {
        return formFields().get(4);
    }

    private WebElement stateField() {
        return formFields().get(5);
    }

    private WebElement submitBtn() {
        return driver.findElement(By.id("submitButton"));
    }

    public void CreateNewAddress(String country, String name, String mobileNumber,
                                 String zipcode, String address,String city, String state) {
        countryField().sendKeys(country);
        nameField().sendKeys(name);
        mobileNumberField().sendKeys(mobileNumber);
        zipcodeField().sendKeys(zipcode);
        addressField().sendKeys(address);
        cityField().sendKeys(city);
        stateField().sendKeys(state);
        submitBtn().click();
    }

    public String getSuccessMessage() {
        return successMessage().getText();
    }

    public void waitForSuccessMsgToDisappear() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.invisibilityOf(successMessage()));
    }
}
