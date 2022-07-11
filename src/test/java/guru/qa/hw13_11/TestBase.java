package guru.qa.hw13_11;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.config.CredentialsConfig;
import guru.qa.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {
    public static CredentialsConfig credentialsConfig = ConfigFactory.create(CredentialsConfig.class);

    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;

        Configuration.baseUrl = "https://demoqa.com/";

        Configuration.browserSize = System.getProperty("resolution", "1920x1080");
        Configuration.browserVersion = System.getProperty("version", "100");
        Configuration.browser = System.getProperty("browser", "chrome");
        String remoteBrowser = System.getProperty("remote", "selenoid.autotests.cloud/wd/hub");
        Configuration.remote = "https://" + credentialsConfig.login() + ":" + credentialsConfig.password() + "@" + remoteBrowser;

    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();

    }

}