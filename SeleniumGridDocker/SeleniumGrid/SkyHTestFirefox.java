package SeleniumGrid;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SkyHTestFirefox extends SuiteBase {

    @BeforeClass
    public void setup() {

    }

    @Test
    public void navToSkyHouse() {
        archSearch.searchForSkyHouse();
        archSearch.getArchitectName();
    }

    @AfterClass
    public void afterClass() throws InterruptedException {
        driver.quit();
    }

}
