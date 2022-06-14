package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MyFirstTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void firstTest() {
        open("/automation-practice-form");

        $("[id=firstName]").setValue("Inna");
        $("[id=lastName]").setValue("Buk");
        $("[id=userEmail]").setValue("InnaBuk@yandex.ru");
        $("[id=genterWrapper]").$(byText("Female")).click();
        $("[id=userNumber]").setValue("8908888888");
        $("[id=dateOfBirthInput]").click();
        $(".react-datepicker__month-select").selectOption("November");
        $(".react-datepicker__year-select").selectOption("1994");
        $(byText("4")).click();
        $("[id=subjectsInput]").sendKeys("Physics");
        $("[id=subjectsInput]").pressEnter();
        $("[id=hobbiesWrapper]").$(byText("Reading")).click();
        $("[id=uploadPicture]").uploadFile(new File("src/test/picture/Summer.jpg"));
        $("[id=currentAddress]").setValue("Address 1");
        $("[id=state]").click();
        $(byText("Haryana")).click();
        $("[id=city]").click();
        $(byText("Karnal")).click();

        $("[id=submit]").click();

        $(".modal-body").shouldHave(text("Inna Buk"),
                text("InnaBuk@yandex.ru"),
                text("Female"),
                text("8908888888"),
                text("04 November,1994"),
                text("Physics"),
                text("Reading"),
                text("Summer.jpg"),
                text("Address 1"),
                text("Haryana Karnal")
        );
    }
}


