package ui_test;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import bo.LoginBO;

public class HomeTest {

    private WebDriver driver;
    private LoginBO loginBO;

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/buttons");
        loginBO = new LoginBO(driver);
    }

    @Test
    public void testWelcomeMessage() {
        // Зверніть увагу, що даний метод має бути викликаним з екземпляру loginBO (якщо getHomeWelcomeMessage() не статичний)
        String message = loginBO.getHomeWelcomeMessage();
        Assert.assertTrue(message.contains("Welcome"), "Привітальне повідомлення не містить слова 'Welcome'");
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
