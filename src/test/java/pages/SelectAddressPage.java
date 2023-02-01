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

    private WebElement selectAddressBtn() {
        return driver.findElement(By.cssSelector("mat-cell > mat-radio-button"));
    }

    private WebElement continueBtn() {
        return driver.findElement(By.cssSelector("mat-card > button"));
    }

    public String getAddress() {
        return driver.findElement(By.cssSelector("mat-row > .cdk-column-Address")).getText();
    }


    public CreateAddressPage clickAddNewAddressBtn() {
        addNewAddressBtn().click();
        return new CreateAddressPage(driver);
    }

    public DeliverySectionPage selectDeliveryAddress() {
        CreateAddressPage createAddressPage = new CreateAddressPage(driver);
        createAddressPage.waitForSuccessMsgToDisappear();
        selectAddressBtn().click();
        continueBtn().click();
        return new DeliverySectionPage(driver);
    }




}
