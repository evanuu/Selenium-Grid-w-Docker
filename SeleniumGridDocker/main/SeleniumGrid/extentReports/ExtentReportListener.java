package SeleniumGrid.extentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.*;

public class ExtentReportListener implements IInvokedMethodListener, ITestListener, ISuiteListener {

    static ExtentReports report;
    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        //before each test case
        test = report.createTest(result.getMethod().getMethodName());
        ExtentFactory.getInstance().setExtent(test);
    }

    @Override
    public void onStart(ISuite suite) {
        //setup method call
        System.out.println("Test Started");
        try {
            report = ExtentReportNG.setupExtentReport();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(ISuite suite) {
        System.out.println("Test Finished");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Name --> " + result.getName() + " --> Successful");
        ExtentFactory.getInstance().getExtent().log(Status.PASS, "Test Case: " + result.getMethod().getMethodName() + " Passed");
        ExtentFactory.getInstance().removeExtentObject();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Name --> " + result.getName() + " --> Failed");
        ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Test Case: " + result.getMethod().getMethodName() + " Failed");
        ExtentFactory.getInstance().getExtent().log(Status.FAIL, result.getThrowable());
        ExtentFactory.getInstance().removeExtentObject();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Name --> " + result.getName() + " --> Skipped");
        ExtentFactory.getInstance().getExtent().log(Status.SKIP, "Test Case: " + result.getMethod().getMethodName() + " Skipped");
        ExtentFactory.getInstance().removeExtentObject();
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        System.out.println("Test Name --> " + result.getName() + " --> Timed Out");
    }

    @Override
    public void onFinish(ITestContext context) {
        //close extent
        report.flush();
    }

}
