package com.demoqa.base;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Properties;

@ExtendWith(TestResultExtension.class)
public abstract class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected TestInfo testInfo;
    private static Properties properties =new Properties();
   protected  static String USER_LOGIN;
    protected static String USER_PASSWORD;
   protected static String PATH_SCREENSHOTS;

    @BeforeAll
    public static void setUp(){
        try {
            String workDir=System.getProperty("user.dir");
            properties.load(new FileInputStream(workDir+"/src/test/constants.properties"));
            USER_LOGIN= properties.getProperty("USER_LOGIN");
            USER_PASSWORD= properties.getProperty("USER_PASSWORD");
            PATH_SCREENSHOTS= properties.getProperty("PATH_SCREENSHOTS");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeEach
    public void init(TestInfo testInfo) {
        this.testInfo = testInfo;
        startChromeDriver();
        driver.manage().window().maximize();

    }

    @AfterEach
    public void quit() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }




    protected FirefoxDriver startFirefoxDriver() {
        return startFirefoxDriver(new FirefoxOptions());
    }

    protected FirefoxDriver startFirefoxDriver(FirefoxOptions options) {
        options.setImplicitWaitTimeout(Duration.ofSeconds(1));
        driver = new FirefoxDriver(options);
        return (FirefoxDriver) driver;
    }

    protected ChromeDriver startChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.setImplicitWaitTimeout(Duration.ofSeconds(1));
        return startChromeDriver(options);
    }

    protected ChromeDriver startChromeDriver(ChromeOptions options) {
        driver = new ChromeDriver(options);
        return (ChromeDriver) driver;
    }


    public static String repeat(String source, int countLetter) {
        StringBuilder sb = new StringBuilder();
        while (sb.toString().length() < countLetter) {
            sb.append(source);
        }
        return sb.substring(0, countLetter);
    }

    public void makeScreenshot(String pathFile, WebDriver driver) throws Exception {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File(pathFile.substring(0, pathFile.length() > 100 ? 100 : pathFile.length())));
    }
}
