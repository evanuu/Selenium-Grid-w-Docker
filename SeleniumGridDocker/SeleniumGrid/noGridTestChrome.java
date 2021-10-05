package SeleniumGrid;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

import java.io.IOException;
import java.time.Duration;

// Needs to be ran from wip.xml
public class noGridTestChrome {
    WebDriver driver;
    ArchDailyPageFactory archSearch;
    BehancePageFactory behanceSearch;

    public static String getChromeDriverPath() {
        String os = System.getProperty("os.name");

        if (os.contains("Windows")) {
            return "windows path";
        } else if (os.contains("Mac")) {
            return "WebDrivers/chromedriverWin";
        } else {
            return "linux path";
        }
    }

    @BeforeClass
    @Parameters("browser")
    public void setup(String browser) throws Exception {

        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", getChromeDriverPath());
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://www.behance.net/");
        } else {
            throw new Exception("browser not accepted");
        }

        behanceSearch = new BehancePageFactory(driver);
//        extentTest = extent.createTest("beforeClass");
    }

    @Test
    public void navToHuaweiProject() throws IOException {
//        extentTest = extent.createTest("navToSkyHouse");
//        extentTest.log(Status.PASS, "hardcode test passed text");

        behanceSearch.navToHuaweiProject();

        Actions action = new Actions(driver);
        WebElement projectTile = driver.findElement(By.xpath("//*[@id=\"site-content\"]/div/header/div[2]/div[1]/div[2]/div/div[3]/button"));
        action.moveToElement(projectTile).click().build().perform();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
//        extent.flush();
    }

}
