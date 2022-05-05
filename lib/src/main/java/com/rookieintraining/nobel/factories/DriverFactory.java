package com.rookieintraining.nobel.factories;

import com.rookieintraining.nobel.devices.Android;
import com.rookieintraining.nobel.devices.HasService;
import com.rookieintraining.nobel.devices.IOS;
import com.rookieintraining.nobel.drivers.Driver;
import com.rookieintraining.nobel.drivers.LoggingAppiumDriver;
import io.appium.java_client.AppiumDriver;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class DriverFactory {

    static Driver driver;
    static String device = System.getProperty("device", "android");
    static List<HasService> deviceList = Collections.synchronizedList(new LinkedList<>());

    public static Driver get() {
        if (Objects.isNull(driver)) {
            driver = determineDeviceDriver(device);
        }
        return driver;
    }

    private static Driver determineDeviceDriver(String device) {
        switch (device) {
            case "android":
                Android droid = new Android();
                deviceList.add(droid);
                return new LoggingAppiumDriver(new AppiumDriver(droid.startService(), droid.getOptions()));
            case "ios":
                IOS ios = new IOS();
                deviceList.add(ios);
                return new LoggingAppiumDriver(new AppiumDriver(ios.startService(), ios.getOptions()));
            default:
                throw new RuntimeException("Option not working");
        }
    }

    public static void stop() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~CLOSING DEVICES!!!!~~~~~~~~~~~~~~~~~~~~~~~~~");
        deviceList.forEach(HasService::stopService);
    }
}
