package bo;

import org.openqa.selenium.WebDriver;
import ui.pages.HomePage;

public class LoginBO {
    private WebDriver driver;
    private HomePage homePage;

    public LoginBO(WebDriver driver) {
        this.driver = driver;
        this.homePage = new HomePage(driver);
    }

    // Приклад бізнес-логіки: відкриття домашньої сторінки та логування
    public void performLogin(String username, String password) {
        homePage.open();
        // Додайте логіку для введення даних та натискання кнопки логіну
        System.out.println("Perform login with " + username);
    }
}
