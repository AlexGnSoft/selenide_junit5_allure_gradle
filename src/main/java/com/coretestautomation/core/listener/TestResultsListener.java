package com.coretestautomation.core.listener;

import io.qameta.allure.Allure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;


public class TestResultsListener implements TestWatcher, AfterAllCallback {

    protected static WebDriver driver;

    private static final List<TestResultStatus> testResultsStatus = new ArrayList<>();
    private static final Logger logger = LogManager.getLogger(TestResultsListener.class);


    private enum TestResultStatus {
        SUCCESSFUL, ABORTED, FAILED, DISABLED;
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        logger.info("Test '" + context.getDisplayName() + "' successfully finished!");

        testResultsStatus.add(TestResultStatus.SUCCESSFUL);
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        String failureMessage = "Test '" +  context.getDisplayName() + "' failed! See screenshot attached.";
        logger.error(failureMessage);

        testResultsStatus.add(TestResultStatus.FAILED);

        Allure.getLifecycle().addAttachment(
                "screenshot", "image/png", "png"
                , ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)
        );
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        logger.info("Test '" + context.getDisplayName() + "' aborted!");

        testResultsStatus.add(TestResultStatus.ABORTED);
    }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        logger.info("Test '" + context.getDisplayName() + "' Disabled!");

        testResultsStatus.add(TestResultStatus.DISABLED);
    }

    @Override
    public void afterAll(ExtensionContext context) {
        Map<TestResultStatus, Long> summary = testResultsStatus.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        logger.info("Overall summary for {} {}");
    }
}
