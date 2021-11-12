package TestNG;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;

import static TestNG.ArchDailyPageFactory.getImageName;

public class BehancePageFactory {
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"site-content\"]/div/header/div[1]/div/div/form/label/input")
    WebElement searchBar;

    @FindBy(linkText = "Huawei P30 Pro")
    WebElement huaweiProject;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[12]/div/div[1]/div/div[2]/div/div/div[2]/div[2]/div[4]/div/div[2]/div[2]/div[1]/div[2]/span")
    WebElement views;

    @FindBy(xpath = "//*[@id=\"project-modules\"]/div[3]/div[1]/div[2]/div/div[1]/img")
    WebElement p30img;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[13]/div/div[1]/div/div[2]/div/div/div[2]/div[1]/figcaption/span")
    WebElement titleInsideProject;


    public BehancePageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Actions
    public void navToHuaweiProject() {
        searchBar.sendKeys("Huawei P30 Pro" + Keys.ENTER);
    }

    public void getImage() throws IOException {
        String img = p30img.getAttribute("src");
        // creating URL
        URL imageURL = new URL(img);
        // read image file
        BufferedImage image = ImageIO.read(imageURL);
        // save image in location
        ImageIO.write(image, "png", new File("./imageFolder/" + getImageName()));
    }

    public static String getImageName() {
        Date d = new Date();
        return "Image_" + d.toString().replace(":", "_").replace(" ", "_") + ".png";
    }

    public void clickProject() {
        huaweiProject.click();
    }

    public void getViews() {
        String pageViews = views.getText();
        System.out.println("Project has " + pageViews + " page views");
    }

}
