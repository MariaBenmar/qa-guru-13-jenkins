package guru.qa.hw13_7;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.conditions.Visible;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ParamsTestWB {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1263x601";
        Configuration.holdBrowserOpen = true;
    }

    @ValueSource(strings = {"обувь", "смартфоны"})
    @ParameterizedTest
    void wbValueSourceTest(String value) {
        Selenide.open("https://www.wildberries.ru/");
        $(".simple-menu__link--sell-on-wb").shouldHave(text("Продавайте на Wildberries"));
        $(".search-catalog__input").click();
        $(".search-catalog__input").setValue(value).pressEnter();
        $(".search-tags.limited").shouldHave(text(value));
    }

    //     @Disabled
    @CsvSource(value = {"обувь, По запросу «обувь» найдено",
            "смартфон, По запросу «смартфон» найдено"
    })

    @ParameterizedTest(name = "При поиске в wildberries.ru по запросу {0} в результатах отображается текст {0}")
    void wbCsvSourceTest(String searchData, String expectedData) {
        Selenide.open("https://www.wildberries.ru/");
        $(".simple-menu__link--sell-on-wb").shouldHave(text("Продавайте на Wildberries"));
        $(".search-catalog__input").click();
        $(".search-catalog__input").setValue(searchData).pressEnter();
        $$(".searching-results__title").find(text(expectedData)).shouldBe(visible);
    }

    @EnumSource(EnumsData.class)
    @ParameterizedTest()
    void wbEnumTest(EnumsData enumsData) {
        Selenide.open("https://www.wildberries.ru/");
        $(".simple-menu__link--sell-on-wb").parent().shouldHave(text("Продавайте на Wildberries"));
        $(".search-catalog__input").click();
        $(".search-catalog__input").setValue(enumsData.goods).pressEnter();
        $(".search-tags.limited").parent().shouldHave(text(enumsData.goods));
    }

    static Stream<Arguments> wbTestComplexProvider() {
        return Stream.of(
                Arguments.of("Обувь", List.of("Категория")),
                Arguments.of("Смартфоны", List.of("Категория"))
        );
    }

    @MethodSource(value = "wbTestComplexProvider")
    @ParameterizedTest(name = "При поиске в wildberries.ru по запросу {0} в результатах отображается текст {1}")
    void wbTestComplex(String searchData, List<String> expectedResult) {
        Selenide.open("https://www.wildberries.ru/");
        $(".simple-menu__link--sell-on-wb").parent().shouldHave(text("Продавайте на Wildberries"));
        $(".search-catalog__input").click();
        $(".search-catalog__input").setValue(searchData).pressEnter();
        $$("#filters").shouldHave(CollectionCondition.texts(expectedResult));
    }
}

