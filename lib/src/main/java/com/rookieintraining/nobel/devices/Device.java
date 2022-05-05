package com.rookieintraining.nobel.devices;

import org.openqa.selenium.Capabilities;

public interface Device<C extends Capabilities> {

    String APP_V1_0_0 = "https://github.com/cloudgrey-io/the-app/releases/download/v1.0.0/TheApp-v1.0.0.apk";
    String APP_V1_0_1 = "https://github.com/cloudgrey-io/the-app/releases/download/v1.0.1/TheApp-v1.0.1.apk";
    String APP_V1_0_2 = "https://github.com/cloudgrey-io/the-app/releases/download/v1.0.2/TheApp-v1.0.2.apk";


    C getOptions();

}
