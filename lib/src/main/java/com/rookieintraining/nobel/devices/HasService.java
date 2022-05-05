package com.rookieintraining.nobel.devices;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public interface HasService<W extends WebDriver, D extends AppiumDriverLocalService, C extends Capabilities> {

    String appiumDriverPath = "/opt/homebrew/bin/appium";
    String nodeJSDriverPath = "/opt/homebrew/bin/node";

    D startService() throws IOException;

    void stopService();

}
