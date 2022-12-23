package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage { //домашняя страница
    private final WebDriver driver;
    private final By hrefHome = By.xpath(".//a[@href='/']");
    private final By hrefLogin = By.xpath(".//a[@href='/login']");
    private final By hrefSignUp = By.xpath(".//a[@href='/signup']");
    private final By hrefProfile = By.xpath(".//a[@href='/profile']"); // ссылки при выполненной авторизации
    private final By hrefLogout = By.xpath(".//a[@href='/logout']"); // ссылки при выполненной авторизации

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickHrefHome() {
        driver.findElement(hrefHome).click();
    }
    public void clickHrefLogin() {
        driver.findElement(hrefLogin).click();
    }
    public void clickHrefSignUp() {
        driver.findElement(hrefSignUp).click();
    }
    public void clickHrefProfile() {
        driver.findElement(hrefProfile).click();
    }
    public void clickHrefLogout() {
        driver.findElement(hrefLogout).click();
    }
}
