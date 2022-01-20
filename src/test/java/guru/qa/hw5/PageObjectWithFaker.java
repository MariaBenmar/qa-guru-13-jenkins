package guru.qa.hw5;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

public class PageObjectWithFaker extends TestBase {

    static String[]
            genderArray = {"Male", "Female", "Other"},
            monthArray = {"January", "February", "March", "April", "May", "June",
                    "July", "August", "September", "October", "November", "December"},
            hobbiesArray = {"Sports", "Reading", "Music"};

    static Faker faker = new Faker();

    public static String
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            gender = genderArray[faker.number().numberBetween(0, 2)],
            address = faker.address().streetAddress(),
            email = faker.internet().emailAddress(),
            phone = faker.numerify("##########"),
            day = String.valueOf(faker.number().numberBetween(10, 29)),
            month = monthArray[faker.number().numberBetween(0, 2)],
            year = String.valueOf(faker.number().numberBetween(1900, 2100)),
            hobby = hobbiesArray[faker.number().numberBetween(0, 2)],
            picturePath = "src/test/resources/photo_girls.jpg",
            nameFile = picturePath.split("/")[picturePath.split("/").length - 1],
            state = "Haryana",
            city = "Panipat",
            subject = "En";


    //Date birth = faker.date().past(1971,12,11);
    @Test
    void fillForm() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        registrationsPage.openPage();
        registrationsPage.typeFirstName(firstName)
                .typeLastName(lastName)
                .typeEmail(email)
                .chooseGender(gender)
                .phoneinput(phone)
                .birthInput(day, month, year)
                .hobbiesCheckbox(hobby)
                .subjectsInput(subject)
                .pictureUpload(picturePath)
                .typeAddress(address)
                .stateCitySelect(state, city)
                .submitClick();


        registrationsPage.checkModalTitle("Thanks for submitting the form")
                .checkResultsValue("Label", "Label")
                .checkResultsValue("Student Name", firstName + " " + lastName)
                .checkResultsValue("Student Email", email)
                .checkResultsValue("Gender", gender)
                .checkResultsValue("Mobile", phone)
                .checkResultsValue("Date of Birth", day + " " + month + "," + year)
                .checkResultsValue("Subjects", subject)
                .checkResultsValue("Hobbies", hobby)
                .checkResultsValue("Picture", nameFile)
                .checkResultsValue("Address", address)
                .checkResultsValue("State and City", state + " " + city);

    }
}