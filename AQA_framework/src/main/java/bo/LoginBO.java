package bo;

import org.openqa.selenium.WebDriver;
import ui.pages.LoginPage;

public class LoginBO {
    private LoginPage loginPage;

    public LoginBO(WebDriver driver) {
        this.loginPage = new LoginPage(driver);
    }

    public void login(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
    }
}
