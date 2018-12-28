package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import scenarios.BaseTest;
import util.AssertUtil;
import util.WaitUtil;

/**
 * Created by sadiq on 27/12/18.
 */
public class FacebookJoinPage {
    private WebDriver driver;

    public FacebookJoinPage(WebDriver driver){

        super();
        this.driver = driver;
    }




    //Join Free Button
    @FindBy(id = "link_join")
    public WebElement joinFreeButton;

    //Facebook Join Button
    @FindBy(id="close_and_go_fb")
    public WebElement joinWithFacebookButton;




    /**
     * Methods for Facebook sign-up page
     */





    public void verifyJoinFreeButtonIsDisplayed(){
        joinFreeButton.isDisplayed();
    }

    public void clickOnJoinFreeButton(){
        joinFreeButton.click();
        WaitUtil.sleep();
    }

    public void verifyJoinWithFacebookIsDisplayed(){
        joinWithFacebookButton.isDisplayed();
    }

    public void clickOnJoinWithFacebookIsClicked(){
        joinWithFacebookButton.click();
    }









}
