package com.rookieintraining.nobel.drivers;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;

public class LoggingAppiumDriver extends Driver implements AbstractDriver {

    public LoggingAppiumDriver(AppiumDriver driver) {
        super(driver);
    }

    @Override
    public AppiumDriver getWrappedDriver() {
        System.out.println("++++++++++++++++++++++++++++++++ Fetching the OG driver");
        return super.getWrappedDriver();
    }

    @Override
    public void get(String url) {
        System.out.println("++++++++++++++++++++++++++++++++ Going to the url : " + url);
        super.get(url);
    }

    @Override
    public String getCurrentUrl() {
        System.out.println("++++++++++++++++++++++++++++++++ Fetching the OG url");
        return super.getCurrentUrl();
    }

    @Override
    public String getTitle() {
        System.out.println("++++++++++++++++++++++++++++++++ Fetching the OG title");
        if(System.getProperty("device").equalsIgnoreCase("android")) {
            System.out.println("++++++++++++++++++++++++++++++++ Can't support title fetch for this device");
            return "NO TITLE FOR YOU!";
        }
        return super.getTitle();
    }

    @Override
    public <X> X takeScreenshot(OutputType<X> target) throws WebDriverException {
        System.out.println("++++++++++++++++++++++++++++++++ Taking a screenshot");
        return super.takeScreenshot(target);
    }

    @Override
    public void quit() {
        System.out.println("++++++++++++++++++++++++++++++++ Quiting the OG driver");
        super.quit();
    }
}
