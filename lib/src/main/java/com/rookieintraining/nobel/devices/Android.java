package com.rookieintraining.nobel.devices;

import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.Capabilities;

import java.io.File;

public class Android implements Device, HasService {

    AppiumDriverLocalService androidDriverService;

    @Override
    public Capabilities getOptions() {
        return new UiAutomator2Options()
                .setDeviceName("Android Emulator")
                .setFullReset(false)
                .withBrowserName("Chrome")
                .setAvd("Pixel_3a");
    }

    @Override
    public AppiumDriverLocalService startService() {
        androidDriverService = new AppiumServiceBuilder()
                .usingDriverExecutable(new File(nodeJSDriverPath))
                .withAppiumJS(new File(appiumDriverPath))
                .withIPAddress("0.0.0.0")
                .usingAnyFreePort()
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .withArgument(GeneralServerFlag.LOG_LEVEL,"error")
                .withArgument(GeneralServerFlag.ALLOW_INSECURE, "chromedriver_autodownload")
                .build();
        androidDriverService.start();

        return androidDriverService;
    }

    @Override
    public void stopService() {
        androidDriverService.stop();
    }
}
