import com.github.javafaker.Faker;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pom.SignUpPage;

import java.util.concurrent.TimeUnit;

@RunWith(Parameterized.class)

public class SignUpTest {
    static Faker faker = new Faker();
    private WebDriver driver;
    private String email;
    private String name;
    private String password;

    public SignUpTest(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }

    @Parameterized.Parameters
    public static Object[][] fieldData() {
        return new Object[][]{
                {faker.internet().emailAddress(), faker.name().firstName(),faker.internet().password(3,9)}, //регистарция с заполнением всех полей
                {faker.internet().emailAddress(), "",faker.internet().password(3,9)}, //регистарция с заполнением обязательных полей email и password
                {"", "",faker.internet().password(3,9)}, //регистарция с заполнением только поля password
                {faker.internet().emailAddress(), "",""}, //регистарция с заполнением только поля email - БАГ, т.к. достаточно заполнения только одного поля Email
        };
    }
    @Before
    public void setUp() {
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://localhost:5000/signup");
    }
    @Test
    public void testSignUp() {
        SignUpPage signUpPage = new SignUpPage(driver);

        signUpPage.setEmail(email);
        signUpPage.setName(name);
        signUpPage.setPassword(password);
        signUpPage.clickSignUp();
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}

