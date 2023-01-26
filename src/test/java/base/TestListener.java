package base;

import io.qameta.allure.Allure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import static base.BaseTest.driver;

public class TestListener implements TestWatcher, AfterAllCallback {

    private static final List<TestResultStatus> testResultsStatus = new ArrayList<>();
    private static final Logger logger = LogManager.getLogger(TestListener.class);

    private enum TestResultStatus {
        SUCCESSFUL, ABORTED, FAILED, DISABLED;
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        Allure.getLifecycle().addAttachment(
                "screenshot", "image/png", "png"
                , ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)
        );


        logger.error("Test Failed for test {}: ", context.getDisplayName());

        testResultsStatus.add(TestResultStatus.FAILED);

        driver.close();
        driver.quit();
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        logger.info("Test Successful for test {}: ", context.getDisplayName());

        testResultsStatus.add(TestResultStatus.SUCCESSFUL);

        driver.close();
        driver.quit();
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        logger.info("Test Aborted for test {}: ", context.getDisplayName());

        testResultsStatus.add(TestResultStatus.ABORTED);
    }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        logger.info("Test Disabled for test {}: with reason :- {}",
               context.getDisplayName(),
               reason.orElse("No reason"));

        testResultsStatus.add(TestResultStatus.DISABLED);
    }

    @Override
    public void afterAll(ExtensionContext context) throws Exception {
        Map<TestResultStatus, Long> summary = testResultsStatus.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        logger.info("Test result summary for {} {}", context.getDisplayName(), summary.toString());
    }
}
