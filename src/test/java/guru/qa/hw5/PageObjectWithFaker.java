package guru.qa.hw5;

import com.codeborne.selenide.Condition;
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
        registrationsPage.openPage();
        registrationsPage.typeFirstName(firstName)
                .typeLastName(lastName)
                .typeEmail(email)
                .chooseGender("Female")
                .phoneinput("0123456789")
                .birthInput("11", "December", "1971")
                .hobbiesCheckbox("Reading", "Sports")
                .subjectsInput("En")
                .pictureUpload()
                .typeAddress(address)
                .stateCitySelect("Haryana", "Panipat");

        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(Condition.text("Thanks for submitting the form"));

    }
}