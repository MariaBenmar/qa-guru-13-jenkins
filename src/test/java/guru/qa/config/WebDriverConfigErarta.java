package guru.qa.config;

import org.aeonbits.owner.Config;

import java.net.URL;

@Config.Sources("classpath:config/${host}.properties")

public interface WebDriverConfigErarta extends Config {

    @Key("baseUrl")
    @DefaultValue("https://www.erarta.com/")
    String getBaseUrl();

    @Key("browserName")
    @DefaultValue("CHROME")
    String getBrowser();

    @Key("browserVersion")
    @DefaultValue("100.0")
    String getBrowserVersion();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String getBrowserSize();

    @Key("remoteUrl")
    URL getRemoteURL();

    @Key("remoteWebDriver")
    @DefaultValue("https://localhost:4444")
    String getRemoteWebDriver();

}