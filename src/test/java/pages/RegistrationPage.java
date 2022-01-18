package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.Value;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    // locators & elements
    final String
            LINK = "https://demoqa.com/automation-practice-form",
            FORM_TITLE = "Student Registration Form";

    private final SelenideElement
            welcomeFormTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderRadio = $("#genterWrapper"),
            phoneInput = $("#userNumber"),
            birthInput = $("#dateOfBirthInput"),
            hobbiesCheckbox = $("#hobbiesWrapper"),
            subjectsInput = $("#subjectsInput"),
            pictureUpload = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateCitySelect = $("#stateCity-wrapper");

    //methods
    public RegistrationPage openPage() {
        open(LINK);
        welcomeFormTitle.shouldHave(text(FORM_TITLE));
        return this;
    }

    public RegistrationPage typeFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage typeLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage typeEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    //public RegistrationsPage typeGender(String value) {
    //  genderSelect.setValue(value);
    public RegistrationPage chooseGender(String value) {
        genderRadio.find(byText(value)).click();
        return this;
    }

    public RegistrationPage phoneinput(String value) {
        phoneInput.setValue(value);
        return this;
    }

    public RegistrationPage birthInput(String day, String month, String year) {
        birthInput.click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $$(".react-datepicker__day").find(text(day)).click();
        return this;
    }

    public RegistrationPage hobbiesCheckbox(String hobby1, String hobby2) {
        hobbiesCheckbox.findElement(byText(hobby1)).click();
        hobbiesCheckbox.findElement(byText(hobby2)).click();
        return this;
    }

    public RegistrationPage subjectsInput(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage pictureUpload() {
        pictureUpload.scrollIntoView(true);
        pictureUpload.uploadFile(new File("src/test/resources/photo_girls.jpg"));
        return this;
    }

    public RegistrationPage typeAddress(String value) {
        addressInput.setValue(value);
        return this;
    }

    public RegistrationPage stateCitySelect(String value1, String value2) {
        $("#state").click();
        stateCitySelect.$(byText(value1)).click();
        $("#city").click();
        stateCitySelect.$(byText(value2)).scrollTo().click();
        return this;
    }

}