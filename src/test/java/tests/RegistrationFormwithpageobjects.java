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

        registrationFormPage.openPage()
                .setFirstName(TestData.firstName)
                .setLastName(TestData.lastName)
                .setEmail(TestData.usermail)
                .setGender(TestData.choosegender)
                .setNumber(TestData.usernumber)
                .setBirthDate(TestData.birthDay, TestData.birthMonth, TestData.birthYear)
                .setSubject(TestData.subjects)
                .setHobby(TestData.hobby)
                .setPicture(TestData.picture)
                .setCurrentAddress(TestData.address)
                .setState(TestData.state)
                .setCity(TestData.city)
                .submit();

        registrationFormPage
                .checkResult("Student Name", TestData.firstName + " " + TestData.lastName)
                .checkResult("Student Email", TestData.usermail)
                .checkResult("Gender", TestData.choosegender)
                .checkResult("Mobile", TestData.usernumber)
                .checkResult("Date of Birth", TestData.birthDay + " " + TestData.birthMonth + "," + TestData.birthYear)
                .checkResult("Subjects", TestData.subjects)
                .checkResult("Hobbies", TestData.hobby)
                .checkResult("Picture", "Summer.jpg")
                .checkResult("Address", TestData.address)
                .checkResult("State and City", TestData.state + " " + TestData.city);

    }
}


