package guru.qa.hw13_16;

import com.codeborne.selenide.Configuration;
import guru.qa.config.WebDriverConfigErarta;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.open;

public class TestBase {

    private WebDriver driver;

    @BeforeAll
    public static void setUp() {
        WebDriverConfigErarta WebDriverConfigErarta = ConfigFactory.create(WebDriverConfigErarta.class, System.getProperties());

        Configuration.browser = WebDriverConfigErarta.getBrowser();
        Configuration.browserVersion = WebDriverConfigErarta.getBrowserVersion();
        Configuration.browserSize = WebDriverConfigErarta.getBrowserSize();
        if (!WebDriverConfigErarta.getRemoteWebDriver().equals("")) {
            Configuration.remote = WebDriverConfigErarta.getRemoteWebDriver();
        }
        String baseUrl = System.getProperty("baseUrl");
        if (Objects.isNull(baseUrl)) {
            baseUrl = "https://www.erarta.com/";
        }
        open(baseUrl);
    }

    @AfterAll
    public void clean() {
        driver.quit();

    }
}