package org.example.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.properties.PropertyHolder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
    private final static PropertyHolder properties = new PropertyHolder();
    private static WebDriver webDriver;

    public static WebDriver getWebDriver() {
        if(webDriver == null) {
            switch (properties.readProperty("browser")) {
                case "chrome" -> {
                    WebDriverManager.chromedriver().setup();
                    webDriver = new ChromeDriver();
                }
                case "firefox" -> {
                    WebDriverManager.firefoxdriver().setup();
                    webDriver = new FirefoxDriver();
                }
                default -> throw new IllegalArgumentException("Incorrect browser name");
            };
        }
        return webDriver;
    }
}
