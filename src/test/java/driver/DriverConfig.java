package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverConfig {

    private static DriverConfig instance;
    private final WebDriver webDriver;

    private DriverConfig() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    public static DriverConfig getInstance() {
        if (instance == null) {
            instance = new DriverConfig();
        }
        return instance;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }
}
