package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {
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

    public Select selectSecurityField() {
        WebElement selectElement = driver.findElement(By.className(".mat-select-required"));
        return new Select(selectElement);
    }

    public void selectSecurityQuestion() {
        selectSecurityField().selectByVisibleText("Mother's maiden name?");
    }

    public WebElement securityAnswerField() {
        return driver.findElement(By.cssSelector("#securityAnswerControl"));
    }

    public WebElement registerBtn() {
        return driver.findElement(By.cssSelector("#registerButton"));
    }

    public void login(String email, String password, String repeatPassword, String securityAnswer) {
        emailField().sendKeys(email);
        passwordField().sendKeys(password);
        repeatPasswordField().sendKeys(repeatPassword);
        selectSecurityQuestion();
        securityAnswerField().sendKeys(securityAnswer);
        registerBtn().click();
    }

}

