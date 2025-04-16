package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    private static WebDriver driver;

    // Метод для отримання драйвера (можна розширювати для підтримки декількох браузерів)
    public static WebDriver getDriver(String browser) {
        if(driver == null) {
            if(browser.equalsIgnoreCase("chrome")) {
                // Вкажіть шлях до chromedriver, якщо він не встановлений системно
                System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");
                driver = new ChromeDriver();
            } else if(browser.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver", "path/to/geckodriver.exe");
                driver = new FirefoxDriver();
            } else {
                throw new IllegalArgumentException("Unsupported browser: " + browser);
            }
        }
        return driver;
    }

    public static void quitDriver() {
        if(driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
