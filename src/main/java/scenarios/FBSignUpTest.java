package scenarios;

import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.FaceBookLoginPage;
import pages.FacebookJoinPage;
import util.ConfigReader;
import util.LogUtil;

/**
 * Created by sadiq on 26/12/18.
 */
public class FBSignUpTest extends BaseTest{

    private static Logger _log = LoggerFactory.getLogger(FBSignUpTest.class);


    String baseUrl = ConfigReader.get("baseURL");

    String sTestCaseName=this.getClass().getSimpleName().trim();


    FacebookJoinPage fbJoinPage;
    FaceBookLoginPage fbLoginPage;




    @BeforeClass
    public void init(){

        LogUtil.info("Before Login");
        LogUtil.startTestCase(sTestCaseName);
        fbJoinPage = PageFactory.initElements(driver, FacebookJoinPage.class);
        fbLoginPage = PageFactory.initElements(driver, FaceBookLoginPage.class);


    }


    @Test(description = "navigate to cashkaro beta website",priority = 0)
    public void navigateToCashKaroPage(){

        LogUtil.info("Navigating to cashkaro page");
        openCashKaro(baseUrl);



    }

    @Test(description = "navigate to JoinFree page",priority = 1)
    public void navigateToJoinFreePage(){



        LogUtil.info("Click on Join free button");

        fbJoinPage.verifyJoinFreeButtonIsDisplayed();
        fbJoinPage.clickOnJoinFreeButton();


    }


        @Test(description = "Click on join with facebook button",priority = 2)
        public void navigateToJoinWithFacebookPage(){

        fbJoinPage.verifyJoinWithFacebookIsDisplayed();

        LogUtil.info("Click on Join with facebook button");
        fbJoinPage.clickOnJoinWithFacebookIsClicked();
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
