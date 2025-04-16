package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CustomDriverProvider {

    public static WebDriver createChromeDriverWithProfile() {
        // Налаштовуємо ChromeOptions
        ChromeOptions options = new ChromeOptions();

        // Шлях до вашого профілю Chrome (змініть, щоб відповідав вашій системі)
        options.addArguments("user-data-dir=C:\\Users\\mypcl\\AppData\\Local\\Google\\Chrome\\User Data\\Default");

        // (За бажанням, можна також завантажити розширення adblock, розкоментувавши наступні рядки)
        //File adBlockExtension = new File("C:\\path\\to\\adblock_extension.crx");
         //options.addExtensions(adBlockExtension);

        // Повертаємо об'єкт WebDriver з налаштованими опціями
        return new ChromeDriver(options);
    }
}
