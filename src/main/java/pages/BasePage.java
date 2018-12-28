package pages;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import scenarios.BaseTest;
import util.AssertUtil;
import util.ConfigReader;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.LogUtil;
import util.WaitUtil;


/**
 * Created by sadiq on 25/12/18.
 */
public class BasePage {

    private static Logger _log = LoggerFactory.getLogger(BasePage.class);

    public WebDriver driver;



    public BasePage(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }



    public void sendKeysByWebElement(WebElement element, String value) {
        try {
            WaitUtil.sleep(500);
            element.isDisplayed();
            element.clear();
            element.click();
            element.sendKeys(value);
            WaitUtil.sleep(500);
        } catch (NullPointerException e){
            LogUtil.error(e.getMessage());
            e.printStackTrace();
        } catch (InvalidSelectorException e){
            LogUtil.error(e.getMessage());
            e.printStackTrace();
        }
    }

    public void  verifyTabTitle(String text){
         AssertUtil.assertTruePageText(text);
    }

    public String getText(WebElement element) {
        return element.getText();
    }


    public Boolean isElementDisplayedOnThePage(WebElement element)
    {
        try
        {
            return element.isDisplayed();
        }
        catch (Exception e)
        {
            return false;
        }
    }




}