package ui.wrappers;

import java.time.Duration;  // Додано імпорт класу Duration
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomWebElement {
    private WebElement element;
    private WebDriver driver;

    public CustomWebElement(WebDriver driver, WebElement element) {
        this.driver = driver;
        this.element = element;
    }

    public void click() {
        // Додавання логування або додаткових очікувань
        System.out.println("Клік по елементу: " + element);
        waitForVisibility();
        element.click();
    }

    public String getText() {
        waitForVisibility();
        return element.getText();
    }

    private void waitForVisibility() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(element));
    }
}
