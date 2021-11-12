package TestNG;

import junit.framework.AssertionFailedError;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class BehanceChrome extends SuiteBase {

    @Test (priority = 1)
    public void navToHuawei() {
        behanceSearch.navToHuaweiProject();
        behanceSearch.clickProject();
    }

    @Test (priority = 2)
    public void checkTitle() {
        String expected = "Huawei P30 Pro";
        String actual = behanceSearch.titleInsideProject.getText();
        if (!expected.equals(actual)) {
            throw new AssertionFailedError("Incorrect title found");
        }
    }

    @Test (priority = 3)
    public void liArrayCheck() {
        List<WebElement> elementList = driver.findElements(By.xpath("//*[@id=\"app\"]/div[1]/div/div[13]/div/div[1]/div/div[2]/div/div/div[2]/div[2]/div[4]/div/div[2]/div[3]/div[1]/ul"));
        String elementString = "";

        for(int i=0; i<elementList.size(); i++) {
            elementString = elementList.get(i).getText();
        }

        //prints string with spacing issue
        System.out.println("string with space issue: " + elementString);
        //replace empty space with ","
        elementString = elementString.replaceAll("\\s+", ", ");
        //convert string to array
        String[] actual = new String[] {elementString};
        String aActual = Arrays.toString(actual);
        System.out.println("actual array: " + aActual);

        String[] expected = {"Photoshop", "Lightroom"};
        System.out.println("expected array: " + Arrays.toString(expected));
        String aExpected = Arrays.toString(expected);

        if (aExpected.equalsIgnoreCase(aActual)) {
            System.out.println("arrays match");
        } else {
            throw new AssertionFailedError("arrays do not match");
        }

    }

    @Test (priority = 4)
    public void img() throws IOException {
        behanceSearch.getImage();
    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
