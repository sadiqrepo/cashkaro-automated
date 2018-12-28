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
import util.WaitUtil;

/**
 * Created by sadiq on 28/12/18.
 */
public class PasswordReset extends BaseTest{


    private static Logger _log = LoggerFactory.getLogger(PasswordReset.class);


    String baseUrl = ConfigReader.get("baseURL");

    String sTestCaseName=this.getClass().getSimpleName().trim();



    RegularSignInPage regularSignInPage;




    @BeforeClass
    public void init(){

        LogUtil.info("Before Login");
        LogUtil.startTestCase(sTestCaseName);

        regularSignInPage=PageFactory.initElements(driver, RegularSignInPage.class);


    }

    @Test(description = "Open sign-in popup",priority = 0)
    public void openSignInPopUp(){
        LogUtil.info("Entering values for regular sign up page");
        openCashKaro(baseUrl);
        regularSignInPage.clickOnSignInLink();

    }

    @Test(description = "Open forgot password popup",priority = 1)
    public void openForgotPasswordPopUp(){
        LogUtil.info("Open forgot password popup");

        regularSignInPage.clickForgotPasswordLink();
        WaitUtil.sleep(3000);
        regularSignInPage.forgotPasswordEmailIdDisplayed();



    }

    @Test(description = "Reset the password",priority = 2)
    public void resetPassword(){
        LogUtil.info("Reset the password");


        regularSignInPage.enterForgotPasswordEmailId();
        regularSignInPage.clickResetPasswordButton();
        regularSignInPage.assertResetPasswordMessage();

    }


    @AfterTest(description = "After test info")
    public void afterTest(){
        LogUtil.endTestCase(sTestCaseName);
    }
}


