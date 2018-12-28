package scenarios;

import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.FaceBookLoginPage;
import pages.FacebookJoinPage;
import pages.RegularSignInPage;
import util.ConfigReader;
import util.LogUtil;

/**
 * Created by sadiq on 28/12/18.
 */
public class RegularSignInTest extends BaseTest {

    private static Logger _log = LoggerFactory.getLogger(RegularSignInTest.class);


    String baseUrl = ConfigReader.get("baseURL");

    String sTestCaseName=this.getClass().getSimpleName().trim();


    FacebookJoinPage fbJoinPage;
    FaceBookLoginPage fbLoginPage;
    RegularSignInPage regularSignInPage;




    @BeforeClass
    public void init(){

        LogUtil.info("Before Login");
        LogUtil.startTestCase(sTestCaseName);
        fbJoinPage = PageFactory.initElements(driver, FacebookJoinPage.class);
        fbLoginPage = PageFactory.initElements(driver, FaceBookLoginPage.class);
        regularSignInPage=PageFactory.initElements(driver, RegularSignInPage.class);


    }

    @Test(description = "Regular sign-in",priority = 0)
    public void regularSignInPage(){
        LogUtil.info("Entering values for regular sign up page");
        openCashKaro(baseUrl);
        regularSignInPage.clickOnSignInLink();
        regularSignInPage.enterSignInEmailId();
        regularSignInPage.enterSignInPassword();
        regularSignInPage.clickOnSignInButton();

        fbLoginPage.myAccountLinkIsDisplayed();

    }





    @AfterTest(description = "After test info")
    public void afterTest(){
        LogUtil.endTestCase(sTestCaseName);
    }
}
