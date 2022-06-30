package tests;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;

public class RegistrationFormwithpageobjects {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    @Test
    void firstTest() {
        String firstName = "Inna";
        String lastName = "Buk";
        String usermail = "inesabuk@yandex.ru";
        String gender = "Female";
        String usernumber = "8908888888";
        String day = "4";
        String month = "November";
        String year = "1994";
        String subject = "Physics";
        String hobby = "Reading";
        String address = "Address 1";
        String picture = "src/test/resources/Summer.jpg";
        String state = "Haryana";
        String city = "Karnal";

        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(usermail)
                .setGender()
                .setNumber()
                .setBirthDate(day, month, year)
                .setSubject(subject)
                .setHobby()
                .setPicture(picture)
                .setCurrentAddress(address)
                .setState(state)
                .setCity(city)
                .submit();

        registrationFormPage
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", usermail)
                .checkResult("Gender", gender)
                .checkResult("Mobile", usernumber)
                .checkResult("Date of Birth", "4 November,1994")
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobby)
                .checkResult("Picture", "Summer.jpg")
                .checkResult("Address", address)
                .checkResult("State and City", state + " " + city);

    }
}


