package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class CustomTestListener implements ITestListener {
    private static final Logger logger = Logger.getLogger(CustomTestListener.class);

    @Override
    public void onStart(ITestContext context) {
        logger.info("Test Suite started: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("Test Suite finished: " + context.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("Test started: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("Test passed: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("Test failed: " + result.getMethod().getMethodName());
        Object testInstance = result.getInstance();
        // Якщо ваш тест реалізує інтерфейс HasDriver
        if (testInstance instanceof HasDriver) {
            WebDriver driver = ((HasDriver) testInstance).getDriver();
            if (driver != null) {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                // Збережіть скріншот у файл або додайте до звіту (наприклад, до Allure)
                logger.error("Screenshot captured for failure.");
            }
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.warn("Test skipped: " + result.getMethod().getMethodName() + ". Reason: " + result.getThrowable());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // За потреби реалізуйте цей метод
    }

    // Допоміжний інтерфейс, щоб тести могли повертати екземпляр WebDriver
    public interface HasDriver {
        WebDriver getDriver();
    }
}
