package com.demoqa.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

@ExtendWith(TestResultExtension.class)
public abstract class BaseTest {
    protected static String USER_LOGIN;
    protected static String USER_PASSWORD;
    protected static String PATH_SCREENSHOTS;
    // protected TestInfo testInfo;
    private static final Properties properties = new Properties();
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeAll
    public static void setUp() {
        try {
            String workDir = System.getProperty("user.dir");
            properties.load(new FileInputStream(workDir + "/src/test/resources/constants.properties"));
            USER_LOGIN = properties.getProperty("USER_LOGIN");
            USER_PASSWORD = properties.getProperty("USER_PASSWORD");
            PATH_SCREENSHOTS = properties.getProperty("PATH_SCREENSHOTS");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String repeat(String source, int countLetter) {
        StringBuilder sb = new StringBuilder();
        while (sb.toString().length() < countLetter) {
            sb.append(source);
        }
        return sb.substring(0, countLetter);
    }

    @AfterEach
    public void quit() {
        if (driver != null) {
            driver.close();
            //  driver.quit();
        }
    }

    public void init(int delta, TypeBrowser browser) {
        //    this.testInfo = testInfo;
        switch (browser) {
            case CHROME -> startChromeDriver(delta);
            case FIREFOX -> startFirefoxDriver(delta);
        }
        driver.manage().window().maximize();

    }

    protected void startFirefoxDriver(int deltaVersion) {
        WebDriverManager wdm = WebDriverManager.firefoxdriver().browserInDocker()
                .dockerDefaultArgs("--disable-gpu,--no-sandbox")
                .browserVersion("latest-" + deltaVersion);
        driver = wdm.create();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
    }

    protected void startChromeDriver(int deltaVersion) {
        WebDriverManager wdm = WebDriverManager.chromedriver().browserInDocker()
                .dockerDefaultArgs("--disable-gpu,--no-sandbox")
                .browserVersion("latest-" + deltaVersion);
        driver = wdm.create();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

    }

    public void makeScreenshot(String pathFile, WebDriver driver) throws Exception {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File(pathFile.substring(0, pathFile.length() > 100 ? 100 : pathFile.length()) + ".png"));
    }
}
