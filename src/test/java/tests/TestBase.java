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

public class TestBase {
    public static CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);
        @BeforeAll
        static void beforeAll() {

            SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

            DesiredCapabilities capabilities = new DesiredCapabilities();

            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);

            Configuration.browserCapabilities = capabilities;
            Configuration.baseUrl = "https://demoqa.com";
            Configuration.browserSize = "1920x1080";


            Configuration.browser = System.getProperty("browser");
            Configuration.browserVersion = System.getProperty("version");
            Configuration.browserSize = System.getProperty("browserSize");

            Configuration.remote = String.format("https://%s:%s@%s", config.login(), config.password(), config.urlCloudSelenoid());
        }

        @AfterEach
        void addAttachments() {
            Attach.screenshotAs("Last screenshot");
            Attach.pageSource();
            Attach.browserConsoleLogs();
            Attach.addVideo();
        }
}
