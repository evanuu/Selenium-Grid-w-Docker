package TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class BehanceFirefox extends SuiteBase {

    @Test
    public void navToHuawei() {
        behanceSearch.navToHuaweiProject();
        behanceSearch.clickProject();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
