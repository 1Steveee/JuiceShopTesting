package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Instant;

public class PaymentPage {

    private WebDriver driver;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement addNewCardExpand() {
        return driver.findElement(By.cssSelector("app-payment-method mat-expansion-panel"));
    }

    private WebElement addNewCardClose() {
        return driver.findElement(By.cssSelector("app-payment-method mat-expansion-panel > .mat-expanded"));
    }

    private WebElement nameField(){
        return driver.findElement(By.cssSelector("div.mat-expansion-panel-body > div > mat-form-field.mat-form-field:nth-child(1) input"));
    }

    private WebElement cardNumberField() {
        return driver.findElement(By.cssSelector("div.mat-expansion-panel-body > div > mat-form-field.mat-form-field:nth-child(2) input"));
    }

    private Select expiryMonthField() {
        return new Select(driver.findElement(By.cssSelector("div.mat-expansion-panel-body > div > mat-form-field.mat-form-field:nth-child(3) select")));
    }

    private Select expiryYearField() {
        return new Select(driver.findElement(By.cssSelector("div.mat-expansion-panel-body > div > mat-form-field.mat-form-field:nth-child(4) select")));
    }

    private WebElement submitBtn() {
        return driver.findElement(By.cssSelector("div > #submitButton"));
    }

    private WebElement paymentCardRadioBtn() {
        return driver.findElement(By.cssSelector("mat-cell > mat-radio-button"));
    }

    private void waitForSuccessMsgToDisappear() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.invisibilityOf(addCardSuccessMessage()));
    }

    private WebElement continueBtn() {
        return driver.findElement(By.cssSelector("mat-card > div > div:nth-child(9) > button.nextButton"));
    }

    public WebElement addCardSuccessMessage() {
        return driver.findElement(By.cssSelector(".mat-simple-snack-bar-content"));
    }


    public void addNewPaymentInfo(String name, String cardNumber, String expirationMonth, String expirationYear) {
        addNewCardExpand().click();
        nameField().sendKeys(name);
        cardNumberField().sendKeys(cardNumber);
        expiryMonthField().selectByValue(expirationMonth);
        expiryYearField().selectByValue(expirationYear);
        submitBtn().click();
    }

    public String addCardSuccessMessageText() {
        return addCardSuccessMessage().getText();
    }

    public OrderSummaryPage selectPaymentCard() {
        waitForSuccessMsgToDisappear();
        addNewCardClose().click();
        paymentCardRadioBtn().click();
        continueBtn().click();
        return new OrderSummaryPage(driver);
    }
}
