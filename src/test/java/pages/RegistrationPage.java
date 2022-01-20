package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

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
            monthInput = $(".react-datepicker__month-select"),
            yearInput = $(".react-datepicker__year-select"),
            hobbiesCheckbox = $("#hobbiesWrapper"),
            subjectsInput = $("#subjectsInput"),
            pictureUpload = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateCitySelect = $("#stateCity-wrapper"),
            submitButton = $("#submit"),
            modalTitle = $("#example-modal-sizes-title-lg"),
            resultsTable = $(".table-responsive");


    private final ElementsCollection
            dayInput = $$(".react-datepicker__day");


    //methods of Registration page
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
        monthInput.selectOption(month);
        yearInput.selectOption(year);
        dayInput.find(text(day)).click();
        return this;
    }

    public RegistrationPage hobbiesCheckbox(String hobby1) {
        hobbiesCheckbox.$(byText(hobby1)).click();
        return this;
    }

    public RegistrationPage subjectsInput(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage pictureUpload(String value) {
        pictureUpload.scrollIntoView(true);
        pictureUpload.uploadFile(new File(String.valueOf(value)));
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

    public RegistrationPage submitClick() {
        submitButton.click();
        return this;
    }

    //methods of Modal window


    public RegistrationPage checkModalTitle(String value) {
        modalTitle.shouldHave(Condition.text(value));
        return this;
    }

    public RegistrationPage checkResultsValue(String key, String value) {
        resultsTable.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }

}