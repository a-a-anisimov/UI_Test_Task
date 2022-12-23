package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage { //страница авторизации
    private final WebDriver driver;
    private final By selectYourEmailField = By.xpath(".//input[@placeholder='Your Email']");
    private final By selectYourPasswordField = By.xpath(".//input[@placeholder='Your Password']");
    private final By selectRememberMeCheckbox = By.xpath("//input[@type='checkbox']");
    private final By selectLoginButton = By.xpath("//button[@class='button is-block is-info is-large is-fullwidth']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void setYourEmail(String yourEmail) {
        driver.findElement(selectYourEmailField).sendKeys(yourEmail);
    }
    public void setYourPassword(String yourPassword) {
        driver.findElement(selectYourPasswordField).sendKeys(yourPassword);
    }
    public void setRememberMeCheckbox() {
        driver.findElement(selectRememberMeCheckbox).click();
    }
    public void clickLoginButton() {
        driver.findElement(selectLoginButton).click();
    }
}
