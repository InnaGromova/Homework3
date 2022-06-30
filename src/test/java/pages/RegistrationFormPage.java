package pages;

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
    genderChoose =  $(byText("Female")),
    usermailInput = $("#userEmail"),
    dateofbirthChoose =  $("#dateOfBirthInput"),
    currentaddressInput =  $("#currentAddress"),
    subjectInput = $("#subjectsInput"),
    hobbyChoose =  $(byText("Reading")),
    pictureSelect =  $("#uploadPicture"),
    usernumberInput = $("#userNumber"),
    stateChoose =  $("#state"),
    cityChoose =  $("#city"),
    submitChoose =  $("#submit");

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
    public RegistrationFormPage setGender(){
        genderChoose.click();
        return this;
    }
    public RegistrationFormPage setEmail(String value){
        usermailInput.setValue(value);
        return this;
    }
    public RegistrationFormPage setBirthDate(String day, String month, String year) {
        dateofbirthChoose.click();
        calenderComponent.setDate(day, month, year);
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
    public RegistrationFormPage setHobby(){
        hobbyChoose.click();
        return this;
    }
    public RegistrationFormPage setPicture(String value){
        pictureSelect.uploadFile(new File(value));
        return this;
    }
    public RegistrationFormPage setNumber(){
        usernumberInput.setValue("8908888888");
        return this;
    }
    public RegistrationFormPage setState(String value){
        stateChoose.click();
        $(byText(value)).click();
        return this;
    }
    public RegistrationFormPage setCity(String value){
        cityChoose.click();
        $(byText(value)).click();
        return this;
    }
    public RegistrationFormPage submit(){
        submitChoose.click();
        return this;
    }
    public RegistrationFormPage checkResult(String key, String value) {
       resultsTableComponent.checkResult(key, value);

       return this;
    }
}
