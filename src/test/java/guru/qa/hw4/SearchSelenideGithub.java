package guru.qa.hw4;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SearchSelenideGithub {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1440x900";

    }

    @Test
        // Откройте страницу Selenide в Github
    void shouldFindSelenideRepoInGithub() {
        open("https://github.com");
        $("[name=q]").setValue("selenide").pressEnter();
        var firstRepositoryFound = $$("ul.repo-list li").first().$("a");
        firstRepositoryFound.click();
        // проверка: в заголовке встречается selenide/selenide
        $("h1").shouldHave(text("selenide / selenide"));

    }

    // Перейдите в раздел Wiki проекта
    void openWikiPages() {
        $("#wiki-tab").$(byText("Wiki")).click();

    }

    // Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
    void shoulFindSoftAssertion() {
        $(".wiki-body").shouldHave(text("Soft assertion")).shouldBe(visible);


    }

    // Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
    void softAssertionClickAndFindJunit5Code() {
        $(".mark-down").shouldHave(text("Soft assertion")).click();
        $(".mark-down").shouldHave(text("Junit5")).shouldBe(visible);

    }

}
