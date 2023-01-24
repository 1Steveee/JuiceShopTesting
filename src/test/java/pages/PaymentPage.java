package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaymentPage {

    private WebDriver driver;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement addNewCard() {
        return driver.findElement(By.cssSelector("app-payment-method mat-expansion-panel"));
    }

    public void addNewPaymentInfo(String name, String cardNumber, String expirationMonth, String expirationYear) {
        addNewCard().click();

    }
}
