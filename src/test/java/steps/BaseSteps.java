package steps;

import manager.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class BaseSteps {


    private static WebDriver driver;
    public static final String WWW_LOGIN_PAGE = "https://eu.devo.com/login";

    @BeforeTest
    @Given("^the user is on login page$")
    public void setup() {
        driver = DriverManager.getWebDriver();
        driver.navigate().to(WWW_LOGIN_PAGE);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @After
    public void afterTest() {
        DriverManager.disposeDriver();
    }
}