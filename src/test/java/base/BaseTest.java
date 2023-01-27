package base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.coretestautomation.core.config.PropertiesFile;
import com.coretestautomation.core.listener.AllureSetup;
import com.coretestautomation.core.listener.TestResultsListener;
import com.coretestautomation.domain.steps.holders.SiteStepsHolder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static com.codeborne.selenide.Selenide.open;
import java.io.File;

@ExtendWith({TestResultsListener.class, AllureSetup.class})
public class BaseTest {

    protected SiteStepsHolder site;
    protected String login;
    protected String password;

    @BeforeAll
    public static void beforeAll() {
        PropertiesFile propertiesFile = new PropertiesFile();
        Configuration.headless = false;
        Configuration.browser = propertiesFile.getBrowser();
        Configuration.browserSize = propertiesFile.getBrowserSize();
        Configuration.browserVersion = propertiesFile.getBrowserVersion();
        open(propertiesFile.getApplicationUrl());
    }

    @AfterAll()
    public static void afterAll() {
        //Selenide.closeWindow();
        Selenide.closeWebDriver();
    }


    protected String getResourcesPath() {
        String defaultPath = System.getProperty("user.dir") +
                File.separator + "src" +
                File.separator + "main" +
                File.separator + "resources" +
                File.separator + "data" +
                File.separator;
        return System.getProperty("resources.path", defaultPath);
    }
}
