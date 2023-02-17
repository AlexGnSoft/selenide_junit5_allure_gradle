package base;

import com.codeborne.selenide.Configuration;
import com.coretestautomation.core.config.PropertiesFile;
import com.coretestautomation.core.helper.IDataGenerator;
import com.coretestautomation.core.listener.TestResultsListener;
import com.coretestautomation.core.logger.Log;
import com.coretestautomation.domain.steps.containers.StepsContainer;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import static com.codeborne.selenide.Selenide.open;

@ExtendWith({TestResultsListener.class})
public class BaseTest implements IDataGenerator {

    protected TestInfo testInfo;
    protected TestReporter testReporter;
    protected static StepsContainer steps = new StepsContainer();
    protected static PropertiesFile propertiesFile = new PropertiesFile();
    protected static String url = propertiesFile.getApplicationUrl();
    protected static String userId = propertiesFile.getUserId();
    protected static String password = propertiesFile.getPassword();


    @BeforeAll
    public static void beforeAll() {
        Configuration.headless = false;
        Configuration.timeout = 5000;
        Configuration.browser = propertiesFile.getBrowser();
        Configuration.browserSize = propertiesFile.getBrowserSize();
        Configuration.browserVersion = propertiesFile.getBrowserVersion();

        open(url);

        steps.loginSteps.loginAs(userId, password);
        steps.loginSteps.isUserLoggedIn(userId);
    }

    @BeforeEach
    void init(TestInfo testInfo, TestReporter testReporter) {
        this.testInfo = testInfo;
        this.testReporter = testReporter;

        Log.info("STARTED test : " + testInfo.getTestMethod().get().getName());
    }

    @AfterAll
    public static void afterAll(TestInfo testInfo) {
        Log.info("FINISHED all tests from class : " + testInfo.getTestClass().get().getName());

        steps.loginSteps.loginOut();
    }
}
