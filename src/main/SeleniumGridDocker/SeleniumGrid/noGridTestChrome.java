package SeleniumGrid;

import SeleniumGrid.extentReports.ExtentFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.reporters.ExitCodeListener;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class noGridTestChrome {
    WebDriver driver;
    ArchDailyPageFactory archSearch;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "D:\\webdrivers\\chromedriver93.exe");
        driver = new ChromeDriver();
        archSearch = new ArchDailyPageFactory(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.archdaily.com/");

//        extentTest = extent.createTest("beforeClass");


    }

    @Test
    public void navToSkyHouse() throws IOException {
//        extentTest = extent.createTest("navToSkyHouse");
//        extentTest.log(Status.PASS, "hardcode test passed text");

        archSearch.searchForSkyHouse();
//        archSearch.clickSkyHarticle();
//        archSearch.getArchitectName();
//        archSearch.getProjectYear();

//        archSearch.getProjectImage();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
//        extent.flush();
    }

}
