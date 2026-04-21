package reporting;

import java.io.ByteArrayInputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.qameta.allure.model.Status;

public class AllureReporter {
    
    private static final Logger logger = LogManager.getLogger(AllureReporter.class);
    
    @Step("Screenshot captured: {stepName}")
    public static void captureScreenshot(WebDriver driver, String stepName) {
        try {
            if (driver != null) {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                Allure.addAttachment(stepName + " Screenshot", "image/png", 
                    new ByteArrayInputStream(screenshot), "png");
                logger.info("Screenshot captured for step: {}", stepName);
            }
        } catch (Exception e) {
            logger.error("Failed to capture screenshot for step {}: {}", stepName, e.getMessage());
        }
    }
    
    @Step("Log message: {message}")
    public static void log(String message) {
        logger.info(message);
        Allure.addAttachment("Log", "text/plain", message);
    }
    
    @Step("Add HTML attachment: {name}")
    public static void addHtmlAttachment(String name, String content) {
        Allure.addAttachment(name, "text/html", content);
    }
    
    @Step("Add JSON attachment: {name}")
    public static void addJsonAttachment(String name, String jsonContent) {
        Allure.addAttachment(name, "application/json", jsonContent);
    }
    
    public static void markStepAsFailed(String message, Throwable throwable) {
        Allure.addAttachment("Error Details", "text/plain", 
            String.format("Error: %s\nStack Trace: %s", message, getStackTrace(throwable)));
        
        Allure.step(message, Status.FAILED);
    }
    
    public static void markStepAsPassed(String message) {
        Allure.step(message, Status.PASSED);
    }
    
    public static void markStepAsSkipped(String message) {
        Allure.step(message, Status.SKIPPED);
    }
    
    public static void markStepAsBroken(String message, Throwable throwable) {
        Allure.addAttachment("Broken Step Details", "text/plain", 
            String.format("Broken Step: %s\nError: %s", message, getStackTrace(throwable)));
        
        Allure.step(message, Status.BROKEN);
    }
    
    private static String getStackTrace(Throwable throwable) {
        if (throwable == null) return "";
        
        try {
            java.io.StringWriter sw = new java.io.StringWriter();
            java.io.PrintWriter pw = new java.io.PrintWriter(sw);
            throwable.printStackTrace(pw);
            return sw.toString();
        } catch (Exception e) {
            return "Failed to get stack trace: " + e.getMessage();
        }
    }
    
    @Step("Add test data attachment")
    public static void addTestData(String testData) {
        Allure.addAttachment("Test Data", "text/plain", testData);
    }
    
    @Step("Add environment information")
    public static void addEnvironmentInfo() {
        StringBuilder envInfo = new StringBuilder();
        envInfo.append("Operating System: ").append(System.getProperty("os.name")).append("\n");
        envInfo.append("Java Version: ").append(System.getProperty("java.version")).append("\n");
        envInfo.append("User: ").append(System.getProperty("user.name")).append("\n");
        envInfo.append("Working Directory: ").append(System.getProperty("user.dir")).append("\n");
        
        Allure.addAttachment("Environment", "text/plain", envInfo.toString());
    }
}
