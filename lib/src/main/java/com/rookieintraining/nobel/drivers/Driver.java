package com.rookieintraining.nobel.drivers;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;

public class Driver implements AbstractDriver {

    AppiumDriver driver;

    public Driver(AppiumDriver driver) {
        this.driver = driver;
    }

    @Override
    public AppiumDriver getWrappedDriver() {
        return driver;
    }

    @Override
    public void get(String url) {
        driver.get(url);
    }

    @Override
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    @Override
    public String getTitle() {
        return driver.getTitle();
    }

    @Override
    public <X> X takeScreenshot(OutputType<X> target) throws WebDriverException {
        return driver.getScreenshotAs(target);
    }

    @Override
    public void quit() {
        driver.quit();
    }
}
