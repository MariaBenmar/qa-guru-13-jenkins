package guru.qa.hw13_16;

import guru.qa.config.WebDriverProviderOld;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebDriverTest {

    private WebDriver driver;

    @BeforeEach
    public void startDriver() {
        driver = new WebDriverProviderOld().get();
    }

    @Test
    public void testGithub() {

        String title = driver.getTitle();
        assertEquals("GitHub: Where the world builds software · GitHub", title);

    }

    @Test
    public void testGithub2() {

        String title = driver.getTitle();
        assertEquals("GitHub: Where the world builds software · GitHub", title);


    }

    @AfterEach
    public void stopDriver() {
        driver.quit();
    }

}
