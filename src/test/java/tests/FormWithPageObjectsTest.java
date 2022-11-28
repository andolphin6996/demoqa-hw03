package tests;

import org.junit.jupiter.api.Test;
public class FormWithPageObjectsTest extends TestBase{


    @Test
    void fillFormTest() {
        String userName = "Anastasia";
        String lastName = "S";
        String email = "andolphin@gmail.com";
        String mobile = "8918972345";
        String BirthDay = ("08");
        String BirthMonth = ("February");
        String BirthYear = ("2021");
        String Gender = "Female";
        String Subject = "English";
        String Hobbies = "Reading";
        String FileUpload = "3.jpg";
        String currentAddress = "Moscow";
        String state = "NCR";
        String city = "Delhi";

        registrationPage.openPage()
                .setFirstName(userName)
                .setLastName(lastName)
                .setEmail(email)
                .setNumber(mobile)
                .setBirthDate(BirthDay, BirthMonth, BirthYear)
                .genderClick(Gender)
                .subjectSet(Subject)
                .hobbbiesClick(Hobbies)
                .fileUpload(FileUpload)
                .currentAddressSet(currentAddress)
                .stateSet(state)
                .citySet(city)
                .submitClick();

        registrationPage.verifyResultsModal()
                .verifyResult("Student Name", userName + " " + lastName)
                .verifyResult("Student Email", email)
                .verifyResult("Gender", Gender)
                .verifyResult("Date of Birth", BirthDay + " " + BirthMonth + "," + BirthYear)
                .verifyResult("Mobile", mobile)
                .verifyResult("Subjects", Subject)
                .verifyResult("Hobbies", Hobbies)
                .verifyResult("Picture", FileUpload)
                .verifyResult("Address", currentAddress)
                .verifyResult("State and City", state + " " + city);


    }
}