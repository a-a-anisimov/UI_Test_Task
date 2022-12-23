import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import pom.HomePage;

import java.util.concurrent.TimeUnit;

public class HomePageTest {
    private WebDriver driver;

    @Before //тестирование главной страницы до авторизации (можно еще проверить ссылки с выполненной авторизацией)
    public void setUp1() {
        //driver = new FirefoxDriver();
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--start-maximized"); //при ширине браузера менее 1089px пропадает навигационная панель - БАГ
        driver = new ChromeDriver(co);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://localhost:5000/");
    }
    @Test
    public void testHrefHome() {
        HomePage homePage = new HomePage(driver);
        homePage.clickHrefHome();
    }
    @Test
    public void testHrefLogin() {
        HomePage homePage = new HomePage(driver);
        homePage.clickHrefLogin();
    }
    @Test
    public void testHrefSignUp() {
        HomePage homePage = new HomePage(driver);
        homePage.clickHrefSignUp();
    }
    @After
    public void tearDown() {
        driver.quit();
    }
 }