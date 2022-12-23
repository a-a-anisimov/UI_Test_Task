import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pom.HomePage;
import pom.LoginPage;

import java.util.concurrent.TimeUnit;

@RunWith(Parameterized.class)

public class LoginPageTest {

    private WebDriver driver;
    private String yourEmail;
    private String yourPassword;

    public LoginPageTest(String yourEmail, String yourPassword) {
        this.yourEmail = yourEmail;
        this.yourPassword = yourPassword;
    }
    @Parameterized.Parameters
    public static Object[][] fieldData() {
        return new Object[][]{
                {"Zeadva@ya.ru","123456"}, //вход с валидными данными email и password
                {"", "aaaaaaaa"}, //вход с пустым email и валидным password
                {"333@mail.ru", ""}, //вход с валидным email и невалидным (пустым) password
                {"Zeadvaaa@ya.ru","123456777"}, //вход с несуществующими данными email и password
                {"aaa@ma.ru", ""}, //вход с валидным email и пустым password (при регистрации поле password не было заполнено) - БАГ!!!
        };
    }
    @Before
    public void setUp() {
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://localhost:5000/login");
    }
    @Test
    public void testLogin() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.setYourEmail(yourEmail);
        loginPage.setYourPassword(yourPassword);
        loginPage.setRememberMeCheckbox();
        loginPage.clickLoginButton();
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
