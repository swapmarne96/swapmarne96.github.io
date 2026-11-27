package com.swapnil.qa.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    private static final Logger log = LogManager.getLogger(BaseTest.class);
    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();
    protected WebDriver driver;

    public static WebDriver getDriver() {
        return DRIVER.get();
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        String browser = System.getProperty("browser", "chrome");
        if (!"chrome".equalsIgnoreCase(browser)) {
            throw new IllegalArgumentException("Unsupported browser: " + browser + ". Currently supported: chrome");
        }

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-notifications");
        if (Boolean.parseBoolean(System.getProperty("headless", "false"))) {
            options.addArguments("--headless=new", "--no-sandbox", "--disable-dev-shm-usage");
        }

        WebDriver webDriver = new ChromeDriver(options);
        DRIVER.set(webDriver);
        driver = webDriver;
        log.info("Started {} browser on thread {}", browser, Thread.currentThread().getId());
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        WebDriver webDriver = DRIVER.get();
        if (webDriver != null) {
            try {
                webDriver.quit();
                log.info("Browser session closed on thread {}", Thread.currentThread().getId());
            } finally {
                DRIVER.remove();
                driver = null;
            }
        }
    }
}
