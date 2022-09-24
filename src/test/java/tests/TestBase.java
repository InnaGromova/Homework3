package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.CredentialsConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.RegistrationFormPage;

public class TestBase {
    public static CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
        @BeforeAll
        static void beforeAll() {

            SelenideLogger.addListener("allure", new AllureSelenide());

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);

            Configuration.browserCapabilities = capabilities;
            Configuration.baseUrl = config.baseurl();

            Configuration.browser = System.getProperty("browser");
            Configuration.browserVersion = System.getProperty("version");
            Configuration.browserSize = System.getProperty("browserSize");
            String login = config.login();
            String password = config.password();
            Configuration.remote = String.format("https://%s:%s@selenoid.autotests.cloud/wd/hub", login, password);
 //           String driver = config.remote_driver();
 //           String login = config.login();
//            String password = config.password();

//            Configuration.remote = String.format("https://%s:%s@%s", login, password,driver);


        }

        @AfterEach
        void addAttachments() {
            Attach.screenshotAs("Last screenshot");
            Attach.pageSource();
            Attach.browserConsoleLogs();
            Attach.addVideo();
        }
}
