package guru.qa.hw6;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class StepLambdaTest {
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUE_NUMBER = 69;

    @Test
    public void testGithub() {
        step("Open main page", () -> {
            open("https://github.com");
        });
        step("Search repository " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").pressEnter();
        });
        step("Go to repository " + REPOSITORY, () -> {
            $(linkText("eroshenkoam/allure-example")).click();
        });
        step("Open tab Issues", () -> {
            $(partialLinkText("Issues")).click();
        });
        step("Check " + ISSUE_NUMBER + " exists", () -> {
            $(withText("" + ISSUE_NUMBER)).shouldBe(Condition.visible);
        });

    }
}
