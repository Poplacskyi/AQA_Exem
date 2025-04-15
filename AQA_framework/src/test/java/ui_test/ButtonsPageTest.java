package ui_test;

import org.openqa.selenium.WebDriver;
import driver.CustomDriverProvider;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.pages.ButtonsPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ButtonsPageTest {
    private WebDriver driver;
    private ButtonsPage buttonsPage;

    @BeforeMethod
    public void setup() {
        // Налаштування драйвера (WebDriverManager автоматично завантажує потрібну версію)
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        // Відкриваємо тестову сторінку, перевірте URL!
        driver.get("https://demoqa.com/buttons");
        buttonsPage = new ButtonsPage(driver);
    }

    @Test
    public void testDoubleClick() {
        buttonsPage.doubleClickButton();
        String msg = buttonsPage.getDoubleClickMessage();
        // Перевірка, що повідомлення містить очікуваний текст
        Assert.assertTrue(msg.contains("You have done a double click"), "Double click message not displayed as expected");
    }

    @Test
    public void testRightClick() {
        buttonsPage.rightClickButton();
        String msg = buttonsPage.getRightClickMessage();
        Assert.assertTrue(msg.contains("You have done a right click"), "Right click message not displayed as expected");
    }

    @AfterMethod
    public void tearDown() {
        if(driver != null){
            driver.quit();
        }
    }
}
