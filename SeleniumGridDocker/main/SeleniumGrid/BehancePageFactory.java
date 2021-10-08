package SeleniumGrid;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BehancePageFactory {
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"site-content\"]/div/header/div[1]/div/div/form/label/input")
    WebElement searchBar;

    @FindBy(linkText = "Huawei | Wisdom")
    WebElement huaweiProject;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[12]/div/div[1]/div/div[2]/div/div/div[2]/div[2]/div[4]/div/div[2]/div[2]/div[1]/div[2]/span")
    WebElement views;

    public BehancePageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Actions
    public void navToHuaweiProject() {
        searchBar.sendKeys("Huawei | Wisdom" + Keys.ENTER);
    }

    public void getColors() {

    }

    public void clickProject() {
        huaweiProject.click();
    }

    public void getViews() {
        String pageViews = views.getText();
        System.out.println("Project has " + pageViews + " page views");
    }

}
