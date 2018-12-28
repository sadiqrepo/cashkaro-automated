package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import util.AssertCustom;
import util.AssertUtil;
import util.WaitUtil;

/**
 * Created by sadiq on 27/12/18.
 */
public class FaceBookLoginPage {

    private WebDriver driver;


    public FaceBookLoginPage(WebDriver driver){

        super();
        this.driver = driver;
    }

    BasePage basePage = new BasePage(driver);
    //FacebookJoinPage fbJoinPage = new FacebookJoinPage(driver);
    WaitUtil newWaitUtil = new WaitUtil(driver);


    //Facebook signup window
    @FindBy(id="homelink")
    public WebElement facebookSignUp;


    //Facebook signup window email
    @FindBy(name = "email")
    public WebElement fbSignUpEmailId;

    //Facebook signup window password
    @FindBy(name = "pass")
    public WebElement fbSignupPassword;

    //Facebook signup login button
    @FindBy(name = "login")
    public WebElement fbSignUpLogin;

    //Using "My Account" text to determine successful Facebook log in page
    @FindBy(id = "link_myaccount")
    public WebElement myAccount;

    //Logout button
    @FindBy(id = "idMenuLogout")
    public WebElement logout;



    public void signUpWithFacebookAccount(){

        fbSignUpEmailId.clear();
        fbSignUpEmailId.sendKeys("8105854242");
        fbSignupPassword.clear();
        fbSignupPassword.sendKeys("te$tca$h");
        fbSignUpLogin.click();

    }

    public void switchToFacebookLoginPageAndSignUp(){

       String parentHandle = driver.getWindowHandle(); // get the current window handle


        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)

        }

        //code to do something on new window
        //WaitUtil.fluentWait(facebookSignUp,3,2);
        //fbJoinPage.clickOnJoinWithFacebookIsClicked();
        WaitUtil.sleep(1000);
        facebookSignUp.isDisplayed();
        signUpWithFacebookAccount();

        //driver.close(); // close newly opened window when done with it
        driver.switchTo().window(parentHandle); // switch back to the original window
        myAccount.isDisplayed();

    }

    public Boolean myAccountLinkIsDisplayed(){
        return basePage.isElementDisplayedOnThePage(myAccount);
    }






}
