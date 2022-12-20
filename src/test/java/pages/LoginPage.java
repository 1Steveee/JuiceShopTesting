package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement notaCustomerLink() {
        return driver.findElement(By.id("newCustomerLink"));
    }

    public String notaCustomerLinkText() {
        return notaCustomerLink().getText();
    }

    public void clickNotCustomerLink() {
        notaCustomerLink().click();
    }
}
