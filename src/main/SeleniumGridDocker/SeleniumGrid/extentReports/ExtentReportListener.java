package SeleniumGrid.extentReports;

import org.testng.*;

public class ExtentReportListener implements IInvokedMethodListener, ITestListener, ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        System.out.println("Test Started");
    }

    @Override
    public void onFinish(ISuite suite) {
        System.out.println("Test Finished");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Name -- " + result.getName() + " -- Successful");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Name -- " + result.getName() + " -- Failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Name -- " + result.getName() + " -- Skipped");
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        System.out.println("Test Name -- " + result.getName() + " -- Timed Out");
    }

}
