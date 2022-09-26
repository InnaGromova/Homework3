package tests;

import config.CredentialsConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.*;
import pages.RegistrationFormPage;
import static io.qameta.allure.Allure.step;

public class RegistrationFormwithpageobjects {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    public static CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);
    @Test
    @Tag("testjob")
    @DisplayName("Checking the registration form")
    void firstTest() {

        step("Fill out the registration form", () -> {

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
        });
        step("Check the results of filling out the registration form", () -> {
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

        });
    }

        @Test
        @Tag("testjob")
      void secondtest() {

            System.out.println(String.format("https://%s:%s@%s", config.login(), config.password(), config.urlCloudSelenoid()));
        }

}

