package util;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;
import scenarios.BaseTest;

import static org.testng.Assert.assertTrue;

/**
 * Created by sadiq on 27/12/18.
 */
public class AssertUtil extends BaseTest{

    private static Logger _log = LoggerFactory.getLogger(AssertUtil.class);



    public static String getPageSource() {
        return new BaseTest().driver.getPageSource();
    }

    public static boolean checkPageSourceContains(String text) {
        return getPageSource().contains(text);
    }




    public static void assertTruePageText(String text) {
        assertTruePageText(text, null);
    }

    public static void assertTruePageText(String text, String failMessage) {
        WaitUtil.sleep(500);
        assertTrue(checkPageSourceContains(text), failMessage);

    }
}
