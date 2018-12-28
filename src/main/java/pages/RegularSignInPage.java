package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.AssertCustom;
import util.WaitUtil;

import java.util.Random;

/**
 * Created by sadiq on 28/12/18.
 */
public class RegularSignInPage {


    private WebDriver driver;

    public RegularSignInPage(WebDriver driver){

        super();
        this.driver = driver;
    }



    public static final String SIGNIN_EMAILID =  "paisatestkaro5@gmail.com";
    public static final String SIGININ_PASSWORD = "te$tCa$h";

    public static final String FG_EMAILID =  "paisatestkaro9@gmail.com";



    /**
     * Elements of the page
     */


    //Sign-in link
    @FindBy(id = "link_signin")
    public WebElement signInLink;

    //Sign-in Popup display
    @FindBy(id = "signin_inline")
    public WebElement signinPopup;

    //Enter email id
    @FindBy(id= "uname")
    public WebElement signinEmailId;

    //Enter password
    @FindBy(id= "pwd")
    public WebElement signinPassword;

    // sign-in button
    @FindBy(id = "btnLayoutSignIn")
    public WebElement signInWithEmailButton;

    //Facebook signin button
    @FindBy(id = "lnkLayoutFacebook")
    public WebElement signInWithFacebook;

    //Forgot password
    @FindBy(id ="lnkLayoutForgotPassword")
    public WebElement forgotPasswordLink;

    //Forgot password pop-up
    @FindBy(className = "fl fw forgot_pass forgot_pass_p")
    public WebElement forgotPasswordPopUp;

    // enter Forgot password email id
    @FindBy(id ="from_email")
    public WebElement forgotPasswordEmailId;

    //Reset password button
    @FindBy(id = "submit_req")
    public WebElement resetPasswordButton;

    // Password reset success
    @FindBy(className = "hd ac")
    public WebElement resetPasswordSuccessMessage;




    /**
     * Methods for Regular sign-in page
     */


    public void clickOnSignInLink(){signInLink.click(); }

    public void enterSignInEmailId(){signinEmailId.sendKeys(SIGNIN_EMAILID); }
    public void enterSignInPassword(){signinPassword.sendKeys(SIGININ_PASSWORD); }
    public void clickOnSignInButton(){signInWithEmailButton.click(); }

    public void clickOnFacebookSignInButton(){signInWithFacebook.click(); }

    /*public void forgotPasswordPopUpIsDisplayed(){

        forgotPasswordPopUp.isDisplayed(); }*/
    public void clickForgotPasswordLink(){forgotPasswordLink.click();

    }


    public void forgotPasswordEmailIdDisplayed(){

        driver.switchTo().frame(0);
        forgotPasswordEmailId.isDisplayed();


    }

    public void enterForgotPasswordEmailId(){
        /*String currentWindow = driver.getWindowHandle();
        driver.switchTo().window(currentWindow);*/


        forgotPasswordEmailId.sendKeys(FG_EMAILID);
    }

    public void clickResetPasswordButton(){resetPasswordButton.click();}


    public void assertResetPasswordMessage(){

        String expected = "PASSWORD SENT!";
        String actual = driver.switchTo().activeElement().getText();
        AssertCustom.assertTrueTextContains(expected, actual);
    }








}
