package bo;

import org.openqa.selenium.WebDriver;
import ui.pages.HomePage;

public class LoginBO {
    private HomePage homePage;

    // Конструктор приймає WebDriver та ініціалізує HomePage
    public LoginBO(WebDriver driver) {
        // Припускаємо, що після логіну ви переходите на головну сторінку
        this.homePage = new HomePage(driver);
    }

    // Метод, який повертає повідомлення привітання з головної сторінки
    public String getHomeWelcomeMessage() {
        // Припустимо, що в HomePage є метод getWelcomeMessage()
        return homePage.getWelcomeMessage();
    }

    // Якщо у вас є інші методи для логіну, їх також можна додати сюди
}
