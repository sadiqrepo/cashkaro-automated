package util;

import com.google.common.base.Function;
import org.openqa.selenium.Alert;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

import java.util.concurrent.TimeUnit;

/**
 * Created by sadiq on 25/12/18.
 */
public class WaitUtil  {

    private WebDriver driver;

    public WaitUtil(WebDriver driver)
    {
        this.driver = driver;
    }


    public static void fluentWait(final WebElement element, final long timeout, final long polltime) {

        new FluentWait<WebElement>(element).
                withTimeout(10, TimeUnit.SECONDS).
                pollingEvery(100,TimeUnit.MILLISECONDS).
                until(new Function<WebElement, Boolean>() {

                          public Boolean apply(WebElement element) {
                              return element.getText().endsWith("04");
                          }
                      }
                );
    }


    public static void sleep() {
        try
        {
            Thread.sleep(2000);
        } catch (InterruptedException ignored)
        {
            LogUtil.info("[INFO] Exception seen while using Thread.sleep()");
            LogUtil.info(String.valueOf(ignored));
        }
    }


    public static void sleep(Integer timeInMillis) {
        try {
            Thread.sleep(timeInMillis);
        } catch (InterruptedException ignored) {
        }
    }

    //Is alert present
    public Alert isAlertPresent(final long timeout){
        Alert element = null;

        try
        {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            element = wait.until(ExpectedConditions.alertIsPresent());
        }
        catch(ElementNotVisibleException e)
        {
            LogUtil.error("\n[Error] Alert is not present. Here's the exception's stack trace");
            LogUtil.error(String.valueOf(e));
        }
        return element;
    }


    public static int getExplicitTimeout()
    {
        //Gets the predefined explicit wait from the config.reader & then returns the same in integer format
        return Integer.parseInt(ConfigReader.get("explicit.wait"));
        //return Long.parseLong(ConfigReader.get("explicit.wait")); //for Long format
    }


    public void setImplicitTimeOut(final long implicitWait){
        try{
            //System.out.println(implicitWait);
            driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
        } catch(NullPointerException e){
            //e.printStackTrace();

        }
    }


    public static void setSleepTimeOut(final long sleepWait) {
        try {
            Thread.sleep(sleepWait);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //Is Element visible after performing an Explicit Wait
    public Boolean isElementVisibleAfterExplicitWait(WebElement element, final long timeout) {
        try
        {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        }
        catch (ElementNotVisibleException e)
        {
            LogUtil.error("\n"+element+ "not found on the page. Here are the exception details: ");
            LogUtil.error(String.valueOf(e));
        }
        return false;
    }


}
