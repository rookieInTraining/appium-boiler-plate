package com.rookieintraining.nobel.devices;

import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.Capabilities;

import java.io.File;
import java.time.Duration;

public class IOS implements Device, HasService {

    AppiumDriverLocalService iOSDriverService;

    @Override
    public Capabilities getOptions() {
        return new XCUITestOptions()
                .setPlatformVersion("15.4")
                .setDeviceName("iPhone 13")
                .autoAcceptAlerts()
                .setCommandTimeouts(Duration.ofSeconds(250))
                .withBrowserName("Safari");
    }

    @Override
    public AppiumDriverLocalService startService() {
        iOSDriverService = new AppiumServiceBuilder()
                .usingDriverExecutable(new File(nodeJSDriverPath))
                .withAppiumJS(new File(appiumDriverPath))
                .withIPAddress("0.0.0.0")
                .usingAnyFreePort()
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .withArgument(GeneralServerFlag.LOG_LEVEL,"error")
                .build();
        iOSDriverService.start();

        return iOSDriverService;
    }

    @Override
    public void stopService() {
        iOSDriverService.stop();
    }
}
