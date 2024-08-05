package com.demoqa.base;

import io.github.bonigarcia.wdm.WebDriverManager;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import util.TypeBrowser;
import org.testng.annotations.AfterMethod;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


public abstract class BaseTest {
    private static final Properties properties = new Properties();
    protected static String USER_LOGIN;
    protected static String USER_PASSWORD;
    protected static String PATH_SCREENSHOTS;
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeClass
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


    @AfterMethod
    public void quit() {
        if (driver != null) {
            driver.close();
        }
    }

    public void init(int delta, TypeBrowser browser) {
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

}
