package com.demoqa.util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public interface TestUtil {


    default String repeat(String source, int countLetter) {
        StringBuilder sb = new StringBuilder();
        while (sb.toString().length() < countLetter) {
            sb.append(source);
        }
        return sb.substring(0, countLetter);
    }

    default void makeScreenshot(String pathFile, WebDriver driver) {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(source, new File(pathFile.substring(0, pathFile.length() > 100 ? 100 : pathFile.length()) + ".png"));
        } catch (IOException e) {
            throw new RuntimeException("Problem with creating screenshot !",e);
        }
    }

}
