package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import testData.RandomData;

public class FormWithFakerTest extends TestBase{


    @Test
    void fillFormTest() {

        RegistrationPage registrationPage = new RegistrationPage();
        Faker faker = new Faker();

        String userName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String gender = RandomData.randomGender();
        String mobile = faker.phoneNumber().subscriberNumber(10);
        String BirthDay = String.valueOf(faker.number().numberBetween(10, 30));
        String BirthMonth = RandomData.randomMonth();
        String BirthYear = String.valueOf(faker.number().numberBetween(1900, 2000));
        String Subject = RandomData.randomSubject();
        String Hobbies = RandomData.randomHobbies();
        String fileUpload = "3.jpg";
        String currentAddress = faker.address().streetAddress();
        String state = RandomData.randomState();
        String city = RandomData.randomCity(state);

        registrationPage.openPage()
                .setFirstName(userName)
                .setLastName(lastName)
                .setEmail(email)
                .setNumber(mobile)
                .setBirthDate(BirthDay, BirthMonth, BirthYear)
                .genderClick(gender)
                .subjectSet(Subject)
                .hobbbiesClick(Hobbies)
                .fileUpload(fileUpload)
                .currentAddressSet(currentAddress)
                .stateSet(state)
                .citySet(city)
                .submitClick();

        registrationPage.verifyResultsModal()
                .verifyResult("Student Name", userName + " " + lastName)
                .verifyResult("Student Email", email)
                .verifyResult("Gender", gender)
                .verifyResult("Date of Birth", BirthDay + " " + BirthMonth + "," + BirthYear)
                .verifyResult("Mobile", mobile)
                .verifyResult("Subjects", Subject)
                .verifyResult("Hobbies", Hobbies)
                .verifyResult("Picture", fileUpload)
                .verifyResult("Address", currentAddress)
                .verifyResult("State and City", state + " " + city);


    }
}