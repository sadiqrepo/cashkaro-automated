package scenarios;

import com.sun.deploy.util.SystemUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import pages.BasePage;
import util.ConfigReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.ConfigWriter;
import util.LogUtil;

/**
 * Created by sadiq on 25/12/18.
 */
public class BaseTest  {

    public static WebDriver driver;


    private static Logger _log = LoggerFactory.getLogger(BaseTest.class);

    @BeforeSuite(alwaysRun = true)
    public void Config()
    {
        ConfigWriter.setPropertyValue("logger.file", "webLogger", ConfigReader.get("config.path"));
    }


    @Parameters({ "browser" })
    @BeforeTest
    public void openBrowser(String browser) {
        try {
            if (browser.equalsIgnoreCase("Firefox")) {
                LogUtil.info("Selected browser is: " + browser);

                String ffpath = ConfigReader.get("geckodriver.path.mac");
                System.setProperty("webdriver.gecko.driver", ffpath);

                driver = new FirefoxDriver();
                FirefoxProfile ffp = new FirefoxProfile();
                ffp.setPreference("accessibility.blockautorefresh", true);




            } else if (browser.equalsIgnoreCase("Chrome")) {
                LogUtil.info("Selected browser is: "+browser);
                String chromePath = ConfigReader.get("chromedriver.path");
                System.setProperty("webdriver.chrome.driver", chromePath);
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                options.addArguments("--disable-notifications");
                driver = new ChromeDriver(options);
            }


            driver.manage().window().setPosition(new Point(0, 0));
            Dimension d = new Dimension(1300, 900);
            driver.manage().window().setSize(d);

        } catch (WebDriverException e) {
            System.out.println(e.getMessage());
        }
    }


    @AfterClass
    public void tearDownBrowser()
    {
        driver.quit();
        LogUtil.info("Closing the browser");
    }

    public void openCashKaro(String baseUrl) {
        driver.get(baseUrl);}







}







