package pageObject.accountPortal.accountDashboard.myAccount;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObject.PageObject;

import static org.testng.AssertJUnit.assertEquals;

public class MyAccountPageOject extends PageObject {

    public MyAccountPageOject(WebDriver driver){
        super(driver);
    }

   @FindBy(xpath = "//input[@name='oldPassword']")private WebElement oldpassword;
    public void setOldPassword(String input){
        oldpassword.click();
        oldpassword.sendKeys(input);
    }

    @FindBy(xpath = "//input[@name='newPassword']")private WebElement newpassword;
    public void setNewPassword(String input) {
        newpassword.click();
        newpassword.sendKeys(input);
    }

    @FindBy(xpath = "//input[@name='confirmPassword']")private WebElement confirmpassword;
    public void confirmPassword(String input) {
        confirmpassword.click();
        confirmpassword.sendKeys(input);
    }

    @FindBy(xpath = "//button[contains(text(),   'update password')]")private WebElement updatepasswordbutton;
    public void updatePasswordButton(String input) {
        updatepasswordbutton.click();
    }

    @FindBy(xpath = "//span[text()='account area']")private WebElement accountarea;
    public void accountArea() {
        accountarea.click();
    }

    @FindBy(xpath = "//p[text()='Wrong password, please try again.']")private WebElement warningmessege;
    public void warningMessege() {
        warningmessege.isDisplayed();
    }

    @FindBy(xpath = "//p[text()='Please enter your old password.']")private WebElement warningmessegeold;
    public void warningMessegeOld() {
        warningmessegeold.isDisplayed();
    }

    @FindBy(xpath = "//p[text()='Please enter your new password.']")private WebElement warningmessegenew;
    public void warningMessegeNew() { warningmessegenew.isDisplayed();
    }

    @FindBy(xpath = "//p[text()='Please confirm your new password.']")private WebElement warningmessegeconfirm;
    public void warningMessegeConfirm() {
        warningmessegeconfirm.isDisplayed();
    }

    @FindBy(xpath = "//button[contains(text(),   'update password')]")private WebElement updatepassword;
    public void updatePassword() {
        updatepassword.click();
    }

    @FindBy(xpath = "//p[text()='New password and confirm password do not match.']")private WebElement nomatchconfirm;
    public void noMatchConfirm() {
        nomatchconfirm.isDisplayed();
    }


}
