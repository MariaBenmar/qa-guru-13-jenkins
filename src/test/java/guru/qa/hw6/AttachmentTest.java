package guru.qa.hw6;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
import io.qameta.allure.AllureLifecycle;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class AttachmentTest {
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUE_NUMBER = 69;

    @Test
    public void testLambda() {
        AllureLifecycle lifecycle = Allure.getLifecycle();
        step("Open main page", () -> {
            open("https://github.com");
        });
        step("Search repository " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").pressEnter();
            lifecycle.addAttachment("Screenshot", "image/png", "png", takeScreenshot());

        });
        step("Go to repository " + REPOSITORY, () -> {
            $(linkText("eroshenkoam/allure-example")).click();
            takeScreenshotAttachment();
        });
        step("Open tab Issues", () -> {
            $(partialLinkText("Issues")).click();
        });
        step("Check " + ISSUE_NUMBER + " exists", () -> {
            $(withText("" + ISSUE_NUMBER)).shouldBe(Condition.visible);
        });


    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    private byte[] takeScreenshotAttachment() {
        final WebDriver driver = WebDriverRunner.getWebDriver();
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    private byte[] takeScreenshot() {
        final WebDriver driver = WebDriverRunner.getWebDriver();
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
