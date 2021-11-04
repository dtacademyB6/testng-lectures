package functionaltests;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomTestListener implements ITestListener {



    public void onTestSuccess(ITestResult result) {

        System.out.println("Test Passed");
    }

    public void onTestFailure(ITestResult result) {

        System.out.println("Test Failed");

        // Taking a screenshot logic here

    }

    public void onTestSkipped(ITestResult result) {

        System.out.println("Test Skipped");
    }








}
