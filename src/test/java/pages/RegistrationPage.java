package pages;

import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();


    public RegistrationPage openPage() {
        open("https://demoqa.com/automation-practice-form");

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        $("#firstName").setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        $("#lastName").setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        $("#userEmail").setValue(value);

        return this;
    }

    public RegistrationPage setNumber(String value) {
        $("#userNumber").setValue(value);

        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage verifyResultsModal() {
        registrationResultsModal.verifyModal();

        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);

        return this;
    }

    public RegistrationPage genderClick(String value) {
        $("#genterWrapper").$(byText(value)).click();

        return this;
    }

    public RegistrationPage subjectSet(String value) {
        $("#subjectsInput").setValue(value);
        $("#subjectsInput").pressEnter();

        return this;
    }

    public RegistrationPage hobbbiesClick(String value) {
        $("#hobbiesWrapper").$(byText(value)).click();

        return this;
    }

    public RegistrationPage fileUpload(String value) {
        $("#uploadPicture").uploadFile(new File("src/test/resources/img/" + value));

        return this;
    }

    public RegistrationPage currentAddressSet(String value) {
        $("#currentAddress").setValue(value);

        return this;
    }
    public RegistrationPage stateSet(String value) {
        $("#react-select-3-input").setValue(value);
        $("#react-select-3-input").pressEnter();

        return this;
    }

    public RegistrationPage citySet(String value) {
        $("#react-select-4-input").setValue(value);
        $("#react-select-4-input").pressEnter();

        return this;
    }

    public RegistrationPage submitClick() {
        $("#submit").click();

        return this;
    }
}
