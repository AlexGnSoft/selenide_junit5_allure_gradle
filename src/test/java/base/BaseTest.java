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

@ExtendWith({TestResultsListener.class, AllureSetup.class})
public class BaseTest {
    protected static SiteStepsHolder site = new SiteStepsHolder();
    protected static PropertiesFile propertiesFile = new PropertiesFile();
    protected static String url = propertiesFile.getApplicationUrl();
    protected static String userId = propertiesFile.getUserId();
    protected static String password = propertiesFile.getPassword();

    @BeforeAll
    public static void beforeAll() {
        Configuration.headless = false;
        Configuration.browser = propertiesFile.getBrowser();
        Configuration.browserSize = propertiesFile.getBrowserSize();
        Configuration.browserVersion = propertiesFile.getBrowserVersion();

        open(url);

        site.loginSteps.loginAs(userId, password);
        site.loginSteps.isUserLoggedIn(userId);
    }

    @AfterAll()
    public static void afterAll() {
        //Selenide.closeWindow();
        Selenide.closeWebDriver();
    }
}
