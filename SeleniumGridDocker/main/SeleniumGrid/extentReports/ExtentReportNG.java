package SeleniumGrid.extentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import okhttp3.internal.platform.Platform;
import org.testng.annotations.*;

import java.io.File;
import java.util.Date;

public class ExtentReportNG {

    static ExtentReports extent;

    public static ExtentReports setupExtentReport() throws Exception {
        Date d = new Date();
//        String fileName = "AutomationReport_" + d.toString().replace(":", "_").replace(" ", "_") + ".html";
        String fileName = "AutomationReport_" + d.toString().replace(":", "-").replace(" ", "_") + ".html";
        String directory = System.getProperty("user.dir") + "/ReportsFolder/";
        new File(directory).mkdirs();
        String path = directory + fileName;

        ExtentSparkReporter sparkReport = new ExtentSparkReporter(path);

        extent = new ExtentReports();
        extent.attachReporter(sparkReport);

        sparkReport.config().setDocumentTitle("Document Title");
        sparkReport.config().setTheme(Theme.DARK);
        sparkReport.config().setReportName("Report Name");

        extent.setSystemInfo("Platform", getPlatform());
//        extent.setSystemInfo("Executed on Environment: ", PropertiesOperations.getPropertyValueByKey("url"));
//        extent.setSystemInfo("Executed on Browser: ", PropertiesOperations.getPropertyValueByKey("browser"));
        extent.setSystemInfo("Executed on OS: ", System.getProperty("os.name"));
        extent.setSystemInfo("Executed by User: ", System.getProperty("user.name"));

        return extent;
    }
    

    public static String getPlatform() {
        String os = System.getProperty("os.name");

        if (os.contains("Windows")) {
            return "Windows";
        } else if (os.contains("Mac")) {
            return "Mac";
        } else {
            return "Linux";
        }
    }

    // create the report path if it does not exist
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

}
