package tests;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.credentialsConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.RegistrationFormPage;

import static io.qameta.allure.Allure.step;

public class RegistrationFormwithpageobjects {
   @BeforeAll
    static void beforeAll() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;

        credentialsConfig credentialsConfig = ConfigFactory.create(config.credentialsConfig.class);

        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
//       Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
 //       Configuration.remote = System.getProperty("anyText");
        String selenoid_url = System.getProperty("selenoid_url");
        String login = credentialsConfig.login();
        String password = credentialsConfig.password();

        Configuration.remote = String.format("https://%s:%s@%s", login, password, selenoid_url);

    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @Test
    @Tag("testjob1")
    @DisplayName("Checking the registration form")
    void firstTest() {

        step("Fill out the registration form",() -> {

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
        step("Check the results of filling out the registration form",() -> {
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
}


