package guru.qa.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config/${device}.properties",
        "classpath:config/mobile.properties",
})
public interface MobileConfig extends Config {

    @Key("device.name")
    String getDeviceName();

    @Key("platform.name")
    String getPlatformName();

    @Key("platform.version")
    String getPlatformVersion();

}