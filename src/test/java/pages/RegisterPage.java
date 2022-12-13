package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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

    public Select selectSecurityField() {
        WebElement selectElement = driver.findElement(By.name("securityQuestion"));
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

    public void login(String email, String password, String securityAnswer) {

        emailField().sendKeys(email);
        passwordField().sendKeys(password);
        repeatPasswordField().sendKeys(password);
        selectSecurityQuestion();
        securityAnswerField().sendKeys(securityAnswer);
        registerBtn().click();
    }

    public String getSucessMessage() {
        return driver.findElement(By.cssSelector("simple-snack-bar > span")).getText();
    }

}

