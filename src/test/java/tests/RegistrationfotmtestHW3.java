//package tests;


//import com.codeborne.selenide.Configuration;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;


//import java.io.File;

//import static com.codeborne.selenide.Condition.text;
//import static com.codeborne.selenide.Selectors.byText;
//import static com.codeborne.selenide.Selenide.$;
//import static com.codeborne.selenide.Selenide.open;

//public class MyFirstTest {
//@BeforeAll
//    static void beforeAll() {
//        Configuration.baseUrl = "https://demoqa.com";
//        Configuration.browserSize = "1920x1080";
//        Configuration.holdBrowserOpen = true;
//    }

//    @Test
//    void firstTest() {
//        open("/automation-practice-form");


//        $("#firstName").setValue("Inna");
//        $("#lastName").setValue("Buk");
 //       $("#userEmail").setValue("InnaBuk@yandex.ru");
//        $("#genterWrapper").$(byText("Female")).click();
//        $("#userNumber").setValue("8908888888");
//        $("#dateOfBirthInput").click();
//        $(".react-datepicker__month-select").selectOption("November");
//        $(".react-datepicker__year-select").selectOption("1994");
//        $(byText("4")).click();
//        $("#subjectsInput").sendKeys("Physics");
 //       $("#subjectsInput").pressEnter();
 //       $("#hobbiesWrapper").$(byText("Reading")).click();
 //       $("#uploadPicture").uploadFile(new File("src/test/java/resources/Summer.jpg"));
//       $("#currentAddress").setValue("Address 1");
//        $("#state").click();
 //       $(byText("Haryana")).click();
//        $("#city").click();
//        $(byText("Karnal")).click();

//        $("#submit").click();

//        $(".modal-body").shouldHave(text("Inna Buk"),
//                text("InnaBuk@yandex.ru"),
 //               text("Female"),
 //               text("8908888888"),
 //               text("04 November,1994"),
 //               text("Physics"),
  //              text("Reading"),
 //               text("Summer.jpg"),
   //             text("Address 1"),
     //           text("Haryana Karnal")
       // );
    //}
//}

