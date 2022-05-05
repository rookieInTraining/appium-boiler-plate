package com.rookieintraining;

import com.rookieintraining.nobel.drivers.Driver;
import com.rookieintraining.nobel.factories.DriverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.io.IOException;

public class Main {

    static final String APP_PKG = "io.cloudgrey.the_app";
    static final String APP_ACT = "com.theapp.MainActivity";

    static final String APP_V1_0_2 = "https://github.com/cloudgrey-io/the-app/releases/download/v1.0.2/TheApp-v1.0.2.apk";

    public static void main(String[] args) throws IOException {
        Driver driver = DriverFactory.get();
        try {
            driver.get("https://duckduckgo.com");

            System.out.println(driver.getTitle());

            File screenShot = driver.takeScreenshot(OutputType.FILE);
            File screenshotFile = new File(System.getProperty("user.dir") + "/sample.jpg");
            FileUtils.copyFile(screenShot, screenshotFile);

        } catch (Exception e) {
            //DO nothing currently
        } finally {
            driver.quit();
            DriverFactory.stop();
        }
    }

}
