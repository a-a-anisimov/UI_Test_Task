package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {
    private final WebDriver driver;
    private final By selectEmailField = By.xpath(".//input[@placeholder='Email']");
    private final By selectNameField = By.xpath(".//input[@placeholder='Name']");
    private final By selectPasswordField = By.xpath("//input[@placeholder='Password']");
    private final By selectSignUpButton = By.xpath("//button[@class='button is-block is-info is-large is-fullwidth']");

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }
    public void setEmail(String email) {
        driver.findElement(selectEmailField).sendKeys(email);
    }
    public void setName(String name) {
        driver.findElement(selectNameField).sendKeys(name);
    }
    public void setPassword(String password) {
        driver.findElement(selectPasswordField).sendKeys(password);
    }
    public void clickSignUp() {
        driver.findElement(selectSignUpButton).click();
    }
}
