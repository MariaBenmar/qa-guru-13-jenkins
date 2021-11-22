package guru.ga.hw2;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchFormDemoca {
    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    void SearchTest() throws InterruptedException {
        open("https://demoqa.com/automation-practice-form");
        $("[id=firstName]").setValue("Some firstname");
        $("[id=lastName]").setValue("Some lastname");
        $("#userEmail").setValue("aaa@aa.aa");
        $("#genterWrapper").$(byText("Female")).click();
        $("[id=userNumber]").setValue("0123456789");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionByValue("1971");
        $(".react-datepicker__month-select").selectOptionByValue("11");
        $(".react-datepicker__day.react-datepicker__day--011").click();

        $("#subjectsInput").setValue("En").pressEnter()
                .setValue("Ma").pressEnter();

        $("#hobbiesWrapper").$(byText("Reading")).click();

        File pic = new File("src/test/resources/photo_girls.jpg");
        $("#uploadPicture").uploadFile(pic);

        $("#currentAddress").setValue("SPB, street, apt");

        $("#state").scrollTo().click();
        $("#state").$(byText("Haryana")).click();
        $("#city").click();
        $("#city").$(byText("Panipat")).click();

        $("#submit").click();

        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Some firstname Some lastname"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("aaa@aa.aa"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Female"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("0123456789"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("11 December,1971"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("English, Maths"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Reading"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("photo_girls.jpg"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("SPB, street, apt"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("Haryana Panipat"));
    }

}
