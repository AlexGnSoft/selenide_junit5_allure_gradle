package com.coretestautomation.core.listener;

import com.coretestautomation.core.logger.Log;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.TestReporter;
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

    private enum TestResultStatus {
        SUCCESSFUL, ABORTED, FAILED, DISABLED;
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        String successMessage = context.getTestMethod().get().getName();
        Log.info("FINISHED test'" + successMessage +  "' SUCCESSFULLY!");

        testResultsStatus.add(TestResultStatus.SUCCESSFUL);
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        String failedMessage = context.getTestMethod().get().getName();
        Log.error("FINISHED test'" + failedMessage +  "' UNSUCCESSFULLY! See screenshot attached.");

        testResultsStatus.add(TestResultStatus.FAILED);

        Allure.getLifecycle().addAttachment(
                "screenshot", "image/png", "png"
                , ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)
        );
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        String abortedMessage = context.getTestMethod().get().getName();
        Log.info("ABORTED '" + abortedMessage +  "' test!");

        testResultsStatus.add(TestResultStatus.ABORTED);
    }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        String disabledMessage = context.getTestMethod().get().getName();
        Log.info("DISABLED '" + disabledMessage +  "' test!");

        testResultsStatus.add(TestResultStatus.DISABLED);
    }

    @Override
    public void afterAll(ExtensionContext context) {

        Map<TestResultStatus, Long> summary = testResultsStatus.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println("TEST RESULTS SUMMERY " + summary.toString());
    }
}
