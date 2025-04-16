package ui_test;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.pages.ButtonsPage;

public class ButtonsTest {

    private WebDriver driver;
    private ButtonsPage buttonsPage;

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/buttons");
        buttonsPage = new ButtonsPage(driver);
    }

    @Test
    public void testDoubleClick() {
        buttonsPage.doubleClickButton();
        String message = buttonsPage.getDoubleClickMessage();
        Assert.assertTrue(message.contains("You have done a double click"), "Подвійний клік не спрацював");
    }

    @Test
    public void testRightClick() {
        buttonsPage.rightClickButton();
        String message = buttonsPage.getRightClickMessage();
        Assert.assertTrue(message.contains("You have done a right click"), "Правий клік не спрацював");
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
