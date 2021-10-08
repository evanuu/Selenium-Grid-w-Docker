package SeleniumGrid;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class noGridChromeFast {
    WebDriver driver;
    BehancePageFactory behanceSearch;

    public static String getChromeDriverPath() {
        String os = System.getProperty("os.name");

        if (os.contains("Windows")) {
            return "WebDrivers/chromedriverWin";
        } else if (os.contains("Mac")) {
            return "WebDrivers/chromedriverMc";
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
//            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://www.behance.net/");
        } else {
            throw new Exception("browser not accepted");
        }

        behanceSearch = new BehancePageFactory(driver);
//        extentTest = extent.createTest("beforeClass");
    }

    @Test
    public void navToHuaweiProject() {
        behanceSearch.navToHuaweiProject();
    }

    @Test
    public void headerList() {
        // get list of header titles
        List<WebElement> headerList = driver.findElements(By.xpath("//*[@id=\"site-content\"]/div/header/div[1]/nav/ul"));
        for (int i = 0; i < headerList.size(); i++) {
            System.out.println(headerList.get(i).getText());

//            String[] actual = {headerList.get(i).getText()};
//            System.out.println(Arrays.toString(actual));
//            List<String> list1 = Arrays.asList("Projects", "Images", "Prototypes", "People", "Moodboards");
//            String[] expectedList = {"Projects", "Images", "Prototypes", "People", "Moodboards"};
//            System.out.println(Arrays.toString(expectedList));
//            Assert.assertEquals(actual, list1, "Header List matches correct list");

        }

        //List<String> expected = Arrays.asList("Projects", "Images", "Prototypes", "People", "Moodboards");

    }

    @Test
    public void tagsList() {
        behanceSearch.clickProject();

        List<WebElement> ownersList = driver.findElements(By.className("ProjectTags-tag-En-"));
        for (int i = 0; i < ownersList.size(); i++) {
            System.out.println(ownersList.get(i).getText());
        }
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
