package SeleniumGrid;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.Scanner;

public class ArchDailyPageFactory {
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"afd-search-actions\"]/input")
    WebElement searchBar;

    @FindBy(xpath = "/html/body/div[5]/div/div[2]/div/div/div[1]/div[1]/div[1]/div[1]/div[1]/a")
    WebElement skyHArticle;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/header[2]/h1")
    WebElement skyHTitle;

    @FindBy(xpath = "//*[@id=\"single-content\"]/div[2]/ul/li[1]/div/span[2]/a")
    WebElement architectName;

    @FindBy(xpath = "//*[@id=\"single-content\"]/div[2]/ul/li[2]/span[2]/a")
    WebElement pojectYear;

    @FindBy(xpath = "//*[@id=\"single-content\"]/figure[1]/a/img")
    WebElement projectImage;


    // initialize page factory
    public ArchDailyPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchForSkyHouse() {
        searchBar.sendKeys("Sky House / MIA Design Studio" + Keys.ENTER);
    }

    public void clickSkyHarticle() {
        skyHArticle.click();
    }

    public void getArchitectName() {
        String archName = architectName.getText();
        System.out.println(archName);
    }

    public void getProjectYear() {
        String year = pojectYear.getText();
        System.out.println(year);
    }

    public void getProjectImage() throws IOException {
//        String image = projectImage.getAttribute("src");
        WebElement l = driver.findElement(By.xpath("//*[@id=\"single-content\"]/figure[1]/a/img"));
        String v = l.getAttribute("src");
        // creating URL
        URL imageURL = new URL(v);
        // read image file
        BufferedImage image = ImageIO.read(imageURL);
        // save image in location
        ImageIO.write(image, "png", new File("./imageFolder/" + getImageName()));
    }

    public static String getImageName() {
        Date d = new Date();
        String fileName = "Image_" + d.toString().replace(":", "_").replace(" ", "_") + ".png";
        return fileName;
    }



}
