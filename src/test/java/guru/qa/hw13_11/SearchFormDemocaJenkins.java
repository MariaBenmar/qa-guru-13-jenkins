package guru.qa.hw13_11;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class SearchFormDemocaJenkins extends TestBase {

    @Test
    @DisplayName("Successful fill form")
    void SearchTest() {

        step("Open main page", () -> {
            open("automation-practice-form");
            executeJavaScript("$('footer').remove()");
            executeJavaScript("$('#fixedban').remove()");
            executeJavaScript("$('#RightSide_Advertisement').remove()");
        });
        step("Fill personal data", () -> {
            $("[id=firstName]").setValue("Some firstname");
            $("[id=lastName]").setValue("Some lastname");
            $("#userEmail").setValue("aaa@aa.aa");
            $("#genterWrapper").$(byText("Female")).click();
            $("[id=userNumber]").setValue("0123456789");
        });
        step("Fill date of birth", () -> {

            $("#dateOfBirthInput").click();
            $(".react-datepicker__year-select").selectOptionByValue("1971");
            $(".react-datepicker__month-select").selectOptionByValue("11");
            $(".react-datepicker__day.react-datepicker__day--011").click();
        });
        step("Fill additional data", () -> {

            $("#subjectsInput").setValue("En").pressEnter()
                    .setValue("Ma").pressEnter();

            $("#hobbiesWrapper").$(byText("Reading")).click();
        });
        step("Upload pic", () -> {
            File pic = new File("src/test/resources/files/photo_girls.jpg");
            $("#uploadPicture").uploadFile(pic);
        });
        step("Fill address", () -> {
            $("#currentAddress").setValue("SPB, street, apt");

            $("#state").scrollTo().click();
            $("#state").$(byText("Haryana")).click();
            $("#city").click();
            $("#city").$(byText("Karnal")).click();
        });
        step("Submit form", () -> {
            $("#submit").scrollIntoView(false);
            $("#submit").click();
        });
        step("Check results", () -> {
            $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Some firstname Some lastname"));
            $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("aaa@aa.aa"));
            $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Female"));
            $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("0123456789"));
            $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("11 December,1971"));
            $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("English, Maths"));
            $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Reading"));
            $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("Picture photo_girls.jpg"));
            $(".table-responsive").$(byText("Address")).parent().shouldHave(text("SPB, street, apt"));
            $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("Haryana Karnal"));
        });
    }
}
