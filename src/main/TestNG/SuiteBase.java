package TestNG;

import com.microsoft.edge.seleniumtools.EdgeOptions;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class SuiteBase {
    protected WebDriver driver;
    BehancePageFactory behanceSearch;

    @BeforeClass(alwaysRun = true)
    @Parameters({"browser", "platform", "url"})
    public void setup(String browser, String platform, String url) throws MalformedURLException {

        driver = getDriverInstance(browser, platform, url);
        behanceSearch = new BehancePageFactory(driver);
    }

    public static WebDriver getDriverInstance(String browser, String platform, String url) throws MalformedURLException {
        //NodeURLString class holds private ip nodeURL string in .gitignore
        NodeURLString n = new NodeURLString();
        String nodeURL = n.nodeURL;
        WebDriver driver = null;
        DesiredCapabilities dcap = new DesiredCapabilities();

        // Set Platform
        if (platform.equalsIgnoreCase("Windows")) {
            dcap.setPlatform(Platform.WINDOWS);
        }
        if (platform.equalsIgnoreCase("MAC")) {
            dcap.setPlatform(Platform.MAC);
        }
        if (platform.equalsIgnoreCase("linux")) {
            dcap.setPlatform(Platform.LINUX);
        }

        // Set Browser
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions opt = new ChromeOptions();
            dcap.merge(opt);
        }
        if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions opt = new FirefoxOptions();
            dcap.merge(opt);
        }
        if (browser.equalsIgnoreCase("microsoft edge")) {
            EdgeOptions opt = new EdgeOptions();
            dcap.merge(opt);
        }
        
        // Set Version coming soon...
        // dcap.setVersion(version);

        driver = new RemoteWebDriver(new URL(nodeURL), dcap);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);

        return driver;
    }

}
