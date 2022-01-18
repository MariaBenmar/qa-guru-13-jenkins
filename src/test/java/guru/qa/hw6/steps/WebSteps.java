package guru.qa.hw6.steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class WebSteps {

    @Step("Open main page")
    public void openRepository() {
        open("https://github.com");
    }

    @Step("Search repository {repository}")
    public void searchForRepository(String repository) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repository);
        $(".header-search-input").pressEnter();
    }

    @Step("Go to repository {repository}")
    public void goToRepository(String repository) {
        $(linkText(repository)).click();
    }

    @Step("Open tab Issues")
    public void openIssueTab() {
        $(partialLinkText("Issues")).click();
    }

    @Step("Check {number} exists")
    public void shouldFindIssueWithNumber(int number) {
        $(withText("" + number)).shouldBe(Condition.visible);
    }
}
