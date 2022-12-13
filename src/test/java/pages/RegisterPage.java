package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {

    /*
    TODO find ID selector for the form fields
     */
    private WebDriver driver;

    public RegisterPage(final WebDriver driver) {
        this.driver = driver;
    }


    public WebElement dismissBtn() {
        return driver.findElement(By.cssSelector("button[aria-label='Close Welcome Banner']"));
    }
    public void clickDismissBtn() {
        dismissBtn().click();
    }

    public WebElement emailField() {
        return driver.findElement(By.cssSelector("#emailControl"));
    }

    public WebElement passwordField() {
        return driver.findElement(By.cssSelector("#passwordControl"));
    }

    public WebElement repeatPasswordField() {
        return driver.findElement(By.cssSelector("#repeatPasswordControl"));
    }


    public void selectSecurityQuestion() {

        final Actions action = new Actions(driver);
        final WebElement dropdown = driver.findElement(By.name("securityQuestion"));
        action.pause(Duration.ofSeconds(2)).click(dropdown).perform();
        final WebElement selectOption = driver.findElement(By.xpath("//mat-option/span[contains(text(), \"Maternal grandmother's first name?\")]"));
        action.pause(Duration.ofSeconds(2)).click(selectOption).perform();
    }

    public WebElement securityAnswerField() {
        return driver.findElement(By.cssSelector("#securityAnswerControl"));
    }

    public WebElement registerBtn() {
        return driver.findElement(By.cssSelector("#registerButton"));
    }

    public void login(String email, String password, String securityAnswer) {
        emailField().sendKeys(email);
        passwordField().sendKeys(password);
        repeatPasswordField().sendKeys(password);
        selectSecurityQuestion();
        securityAnswerField().sendKeys(securityAnswer);
        registerBtn().click();
    }

    public String getSuccessMessage() {
        WebElement successMessage = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("simple-snack-bar > span")));
        return successMessage.getText();
    }

}

