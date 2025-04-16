package ui.tests;

import drivers.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import bo.LoginBO;

public class HomeTest {

    private WebDriver driver;
    private LoginBO userBO;

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.getDriver("chrome");
        driver.get("https://your-application-url.com");
        userBO = new UserBO(driver);
    }

    @Test
    public void testWelcomeMessage() {
        String message = userBO.getHomeWelcomeMessage();
        Assert.assertTrue(message.contains("Welcome"), "Привітальне повідомлення не містить слова 'Welcome'");
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
