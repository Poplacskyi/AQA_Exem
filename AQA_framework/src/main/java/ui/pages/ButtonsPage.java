package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ButtonsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "doubleClickBtn")
    private WebElement doubleClickBtn;

    @FindBy(id = "rightClickBtn")
    private WebElement rightClickBtn;

    @FindBy(id = "doubleClickMessage")
    private WebElement doubleClickMsg;

    @FindBy(id = "rightClickMessage")
    private WebElement rightClickMsg;

    public ButtonsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void doubleClickButton() {

        wait.until(ExpectedConditions.elementToBeClickable(doubleClickBtn));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", doubleClickBtn);

        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClickBtn).perform();
    }

    public String getDoubleClickMessage() {
        WebElement messageElement = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("doubleClickMessage")));
        return messageElement.getText();
    }

    public void rightClickButton() {
        wait.until(ExpectedConditions.elementToBeClickable(rightClickBtn));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", rightClickBtn);
        Actions actions = new Actions(driver);
        actions.contextClick(rightClickBtn).perform();
    }

    public String getRightClickMessage() {
        WebElement msg = wait.until(ExpectedConditions.visibilityOf(rightClickMsg));
        return msg.getText();
    }
}
