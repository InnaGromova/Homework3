package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalenderComponent;
import pages.components.ResultsTableComponent;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormPage {

    public CalenderComponent calenderComponent = new CalenderComponent();
    public ResultsTableComponent resultsTableComponent = new ResultsTableComponent();

    SelenideElement firstNameInput = $("#firstName"),
    lastNameInput = $("#lastName"),
    genderInput =  $(byText("Female")),
    usermailInput = $("#userEmail"),
    dateofbirthInput =  $("#dateOfBirthInput"),
    currentaddressInput =  $("#currentAddress"),
    subjectInput = $("#subjectsInput"),
    hobbyInput =  $(byText("Reading")),
    pictureInput =  $("#uploadPicture"),
    usernumberInput = $("#userNumber"),
    stateInput =  $("#state"),
    cityInput =  $("#city"),
    submitInput =  $("#submit");












    public RegistrationFormPage openPage(){
        open("/automation-practice-form");

        return this;
    }
    public RegistrationFormPage setFirstName(String value){
        firstNameInput.setValue(value);
        return this;
    }
    public RegistrationFormPage setLastName(String value){
        lastNameInput.setValue(value);
        return this;
    }
    public RegistrationFormPage setGender(String value){
        genderInput.click();
        return this;
    }
    public RegistrationFormPage setEmail(String value){
        usermailInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setBirthDate(String day, String month, String year) {
        dateofbirthInput.click();
        calenderComponent.setDate(year);
        return this;
    }

    public RegistrationFormPage setCurrentAddress(String value){
        currentaddressInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setSubject(String value){
        subjectInput.sendKeys(value);
        subjectInput.pressEnter();
        return this;
    }

    public RegistrationFormPage setHobby(String value){
        hobbyInput.click();
        return this;
    }

    public RegistrationFormPage setPicture(String value){
        pictureInput.uploadFile(new File(value));
        return this;
    }

    public RegistrationFormPage setNumber(String value){
        usernumberInput.setValue("8908888888");
        return this;
    }

    public RegistrationFormPage setState(String value){
        stateInput.click();
        $(byText(value)).click();
        return this;
    }

    public RegistrationFormPage setCity(String value){
        cityInput.click();
        $(byText(value)).click();
        return this;
    }

    public RegistrationFormPage Submit(){
        submitInput.click();
        return this;
    }

    public RegistrationFormPage checkResult(String key, String value) {
       resultsTableComponent.checkResult(key, value);

       return this;
    }


}
