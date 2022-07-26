package guru.qa.hw13_16;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.title;
import static org.assertj.core.api.Assertions.assertThat;

public class ErartaTest extends TestBase {

    @Tag("erartaTest")
    @Test
    @DisplayName("Check search results")
    void googleSearchTest() {
        $("#header__search-svg").click();
        $("input.search-popup__input base-input search-input").setValue("Наваждение").pressEnter();
        ($("#search-page__result-title")).shouldHave(text("Наваждение"));
    }

}
