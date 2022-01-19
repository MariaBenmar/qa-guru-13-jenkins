package guru.qa.hw5;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;

public class PageObjectWithFaker extends TestBase {

    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String address = faker.address().streetAddress();
    String email = faker.internet().emailAddress();
    String phone = faker.phoneNumber().cellPhone();

    //Date birth = faker.date().past(1971,12,11);
    @Test
    void fillForm() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        registrationsPage.openPage();
        registrationsPage.typeFirstName(firstName)
                .typeLastName(lastName)
                .typeEmail(email)
                .chooseGender("Female")
                .phoneinput("0123456789")
                .birthInput("11", "December", "1971")
                .hobbiesCheckbox("Reading", "Sports")
                .subjectsInput("En")
                .pictureUpload("src/test/resources/photo_girls.jpg")
                .typeAddress(address)
                .stateCitySelect("Haryana", "Panipat")
                .submitClick()
                .modalCheck("Thanks for submitting the form");

        // $("#submit").click();


    }
}