package com.rookieintraining.nobel.drivers;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;

public interface AbstractDriver {

    AppiumDriver getWrappedDriver();

    void get(String url);

    String getCurrentUrl();

    String getTitle();

    <X> X takeScreenshot(OutputType<X> target) throws WebDriverException;

    void quit();

}
