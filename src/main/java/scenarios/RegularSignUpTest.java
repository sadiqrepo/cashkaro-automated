package scenarios;

import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.FaceBookLoginPage;
import pages.FacebookJoinPage;
import pages.RegularSignUpPage;
import util.AssertCustom;
import util.AssertUtil;
import util.ConfigReader;
import util.LogUtil;

import java.util.NoSuchElementException;

/**
 * Created by sadiq on 27/12/18.
 */
public class RegularSignUpTest extends BaseTest {

    private static Logger _log = LoggerFactory.getLogger(FBSignUpTest.class);


    String baseUrl = ConfigReader.get("baseURL");

    String sTestCaseName=this.getClass().getSimpleName().trim();


    FacebookJoinPage fbJoinPage;
    FaceBookLoginPage fbLoginPage;
    RegularSignUpPage regularSignUpPage;


    @BeforeClass
    public void init(){

        LogUtil.info("Before Login");
        LogUtil.startTestCase(sTestCaseName);
        regularSignUpPage = PageFactory.initElements(driver,RegularSignUpPage.class);
        fbJoinPage = PageFactory.initElements(driver, FacebookJoinPage.class);
        fbLoginPage = PageFactory.initElements(driver, FaceBookLoginPage.class);
    }


    @Test(description = "RegularSignUp",priority = 0)
    public void regularSignUpPage(){

        LogUtil.info("Entering values for regular sign up page");
        openCashKaro(baseUrl);
        fbJoinPage.clickOnJoinFreeButton(); // Navigate to SignUp page

        //Enter Sign up form details
        regularSignUpPage.enterFirstname();
        regularSignUpPage.enterEmailId();
        regularSignUpPage.enterMobileNumber();

        for(int i=0;i<30;i++) {
            try{
            regularSignUpPage.enterPassword();
            regularSignUpPage.enterCaptcha(String.valueOf(5));
            regularSignUpPage.clickOnJoinWithEmail();
                boolean myAccountLink = fbLoginPage.myAccountLinkIsDisplayed();
                if(myAccountLink){ break; }
            } catch (NoSuchElementException e){
            LogUtil.error("Exception seen while signup");
            LogUtil.error(String.valueOf(e));
            }
        }
        regularSignUpPage.closeOtpPopup();
        fbLoginPage.myAccountLinkIsDisplayed();
    }


        @AfterTest(description = "After test info")
                public void afterTest(){
                    LogUtil.endTestCase(sTestCaseName);
        }





    }


