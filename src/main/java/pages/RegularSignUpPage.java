package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Random;

/**
 * Created by sadiq on 27/12/18.
 */
public class RegularSignUpPage {


    private WebDriver driver;

    public RegularSignUpPage(WebDriver driver){

        super();
        this.driver = driver;
    }


    public static final String FIRSTNAME = "paisatestkaro" ;
    public static final String EMAILID =  "paisatestkaro" + new Random().nextInt(100);
    public static final String PASSWORD = "te$tCa$h";
    public static final String MOBILE_NUMBER = "8105854242";




    /**
     * Elements of the page
     */

    //Enter you name input box
    @FindBy(id= "firstname")
    public WebElement signUpFirstName;

    // Enter a valid email address
    @FindBy(name = "email")
    public WebElement signUpEmailId;


    //Password placeholder
    @FindBy(id="pwd-txt")
    public WebElement signUpPasswordPlaceholder;


    //Enter a password input box
    @FindBy(id="password")
    public WebElement signUpPassword;


    //Enter mobile number
    @FindBy(id = "mobile_number")
    public WebElement signUpMobileNumber;


    //Enter the captcha value
    @FindBy(id = "to_be_check")
    public WebElement signUpCaptcha;


    //Join with email button
    @FindBy(id = "join_free_submit")
    public WebElement joinWithEmailButton;


    //OTP pop-up
    @FindBy(id = "otp_popup")
    public WebElement otpPopup;

    //Close OTP popup
    @FindBy(id = "cboxClose")
    public WebElement closeOtpPopup;


    /**
     * Methods for Regular sign-up page
     */


    public void enterFirstname(){

        signUpFirstName.sendKeys(FIRSTNAME);
    }

    public void enterEmailId(){

        signUpEmailId.sendKeys(EMAILID+"@gmail.com");
    }

    public void enterPassword(){
        signUpPasswordPlaceholder.clear();
        signUpPassword.sendKeys(PASSWORD);
    }


    public void enterMobileNumber(){

        signUpMobileNumber.sendKeys(MOBILE_NUMBER);
    }

    public void enterCaptcha(String captcha){

        signUpCaptcha.sendKeys(captcha);
    }

    public void clickOnJoinWithEmail(){
        joinWithEmailButton.click();
    }

    public void closeOtpPopup(){
        otpPopup.isDisplayed();
        closeOtpPopup.click();
    }








}
