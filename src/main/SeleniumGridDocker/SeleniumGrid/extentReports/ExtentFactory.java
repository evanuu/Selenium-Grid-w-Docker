package SeleniumGrid.extentReports;

import SeleniumGrid.SuiteBase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.openqa.selenium.Platform;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.util.Arrays;
import java.util.Date;

public class ExtentFactory {
    private static ExtentReports extent;
    private static ExtentTest extentTest;
    private static Platform platform;
    private static String macPath = System.getProperty("user.dir")+ "/TestReport";
    private static String windowsPath = System.getProperty("user.dir")+ "\\TestReport";
    private static String macReportFileLoc = macPath + "/" + "ReportsFolder/" + getReportName();
    private static String winReportFileLoc = windowsPath + "\\" + "ReportsFolder/" + getReportName();

    // Extent report set name to date
    public static String getReportName() {
        Date d = new Date();
        String fileName = "AutomationReport_" + d.toString().replace(":", "_").replace(" ", "_") + ".html";
        return fileName;
    }

//    public static ExtentReports getInstance() {
//        if (extent == null)
//            createInstance();
//        return extent;
//    }
//
//    // create extent report instance
//    public static ExtentReports createInstance() {
//        platform = getCurrentPlatform();
//        String fileName = getReportFileLocation(platform);
//        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
//        htmlReporter.config().setEncoding("utf-8");
//        htmlReporter.config().setProtocol(Protocol.HTTPS);
//        htmlReporter.config().setDocumentTitle(fileName);
//        htmlReporter.config().setReportName(fileName);
//        htmlReporter.config().setTheme(Theme.STANDARD);
//
//        extent = new ExtentReports();
//        extent.attachReporter(htmlReporter);
//
//        return extent;
//    }
//
//    // select the extent report file location based of platform
//    private static String getReportFileLocation(Platform platform) {
//        String reportFileLocation = null;
//        switch(platform) {
//            case WINDOWS:
//                reportFileLocation = winReportFileLoc;
//                createReportPath(windowsPath);
//                System.out.println("ExtentReport path for Windows " + windowsPath);
//                break;
//            case MAC:
//                reportFileLocation = macReportFileLoc;
//                createReportPath(macPath);
//                System.out.println("ExtentReport path for Mac " + macPath);
//            default:
//                System.out.println("ExtentReport path has not been set: file location problem");
//                break;
//        }
//        return reportFileLocation;
//    }
//
//    // create the report path if it does not exist
//    private static void createReportPath (String path) {
//        File testDirectory = new File(path);
//        if (!testDirectory.exists()) {
//            if (testDirectory.mkdir()) {
//                System.out.println("Directory: " + path + " is created");
//            } else {
//                System.out.println("Failed to create directory: " + path);
//            }
//        } else {
//            System.out.println("Directory already exists: " + path);
//        }
//    }
//
//    // get current platform
//    private static Platform getCurrentPlatform() {
//        if (platform == null) {
//            String opSys = System.getProperty("os.name").toLowerCase();
//            if (opSys.contains("win")) {
//                platform = Platform.WINDOWS;
//            } else if (opSys.contains("linux")) {
//                platform = Platform.LINUX;
//            } else if (opSys.contains("mac")) {
//                platform = Platform.MAC;
//            }
//        }
//        return platform;
//    }






//    @BeforeClass
//    public void extentSetup() {
//        String fileName = getReportName();
//        String directory = System.getProperty("user.dir") + "/ReportsFolder/";
//        new File(directory).mkdirs();
//        String path = directory + fileName;
//        htmlReporter = new ExtentHtmlReporter(path);
//
//        // create extentReports and attach reporter
//        extent = new ExtentReports();
//        extent.attachReporter(htmlReporter);
//
//        // report config
//        htmlReporter.config().setEncoding("utf-8");
//        htmlReporter.config().setProtocol(Protocol.HTTPS);
//        htmlReporter.config().setDocumentTitle("Automation Reports");
//        htmlReporter.config().setReportName("Automation Test Results");
//        htmlReporter.config().setTheme(Theme.STANDARD);
//
//        // make these dynamic based on what driver is launched...?
//        extent.setSystemInfo("Organization", "QA Automation Study");
//        extent.setSystemInfo("Browser", "Chrome");
//        extent.setSystemInfo("Platform", "Windows");
//        extent.setSystemInfo("Selenium Version", "4.0.0-beta-3");
//    }

    @AfterClass
    public void getResults(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
            extentTest.fail("<details><summary><b><font color=red>Exception Occured, click to see details:" + "</font></b></summary>"
                    + exceptionMessage.replaceAll(",", "<br>") + "</details> \n");

            String logText = "<b> Test Method " + result.getMethod().getMethodName() + " Failed</b>";
            Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
            extentTest.log(Status.FAIL, m);
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            String logText = "<b> Test Method " + result.getMethod().getMethodName() + " Successful</b>";
            Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
            extentTest.log(Status.PASS, m);
        } else if (result.getStatus() == ITestResult.SKIP)  {
            String logText = "<b> Test Method " + result.getMethod().getMethodName() + " Skipped</b>";
            Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
            extentTest.log(Status.SKIP, m);
        }
    }

    @AfterSuite
    public void tearDown() {
        // writes everything to the log file
        extent.flush();
    }
}
