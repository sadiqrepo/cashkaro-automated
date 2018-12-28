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
public class FBSignInTest extends BaseTest {

    private static Logger _log = LoggerFactory.getLogger(FBSignInTest.class);


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


    @Test(description = "navigate to cashkaro beta website",priority = 0)
    public void navigateToCashKaroPage(){

        LogUtil.info("Navigating to cashkaro page");
        openCashKaro(baseUrl);
    }

    @Test(description = "Click on to signIn link",priority = 1)
    public void navigateToSignInPopup(){

        LogUtil.info("Click on Sign-In Link");
        regularSignInPage.clickOnSignInLink();


    }


    @Test(description = "Click on join with facebook button",priority = 2)
    public void navigateToFacebookPageSignIn(){

        LogUtil.info("Click on Signin with facebook button");
        regularSignInPage.clickOnFacebookSignInButton();
    }

    @Test(description = "Signup with Facebook Login",priority = 3)
    public void joinWithFacebookLogin(){
        fbLoginPage.switchToFacebookLoginPageAndSignUp();
    }





    @AfterTest(description = "After test info")
    public void afterTest(){
        LogUtil.endTestCase(sTestCaseName);
    }
}
