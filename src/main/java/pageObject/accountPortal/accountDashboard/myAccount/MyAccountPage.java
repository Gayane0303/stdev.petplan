package pageObject.accountPortal.accountDashboard.myAccount;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObject.PageObject;

public class MyAccountPage{
    @FindBy(xpath = "//input[@name='oldPassword']")
    private WebElement oldPasswordField;
    @FindBy(xpath = "//input[@name='newPassword']")
    private WebElement newPasswordField;
    @FindBy(xpath = "//input[@name='confirmPassword']")
    private WebElement confirmPasswordField;
    @FindBy(xpath = "//change-password//button[@class='btn__link--primary']")
    public WebElement confirmButton;
    @FindBy(xpath = "//p[@ng-message='wrongPassword']")
    public WebElement wrongOldPassMsg;
    @FindBy(xpath = "//p[@ng-message='confirmPasswordMatch']")
    public WebElement wrongConfirmPassMsg;
    @FindBy(xpath = "//p[@ng-message='passwordLength']")
    public WebElement shortNewPassMsg;
    @FindBy(xpath = "//change-password//p[@class='ng-binding']")
    public WebElement successfullUpdateMsg;
    @FindBy(xpath = "//change-password//p[@ng-message='required']")
    public WebElement requiredFieldMsg;
    private WebDriver webDriver;

    public MyAccountPage(WebDriver webDriver){
        PageFactory.initElements(webDriver,this);
        this.webDriver = webDriver;
    }

    public void changePassword(String oldPass,String newPass,String confirmPass){
        fillRequiredFields(oldPass,newPass,confirmPass);
        pressConfirmButton();
    }
    public void fillRequiredFields(String oldPass,String newPass,String confirmPass){
        oldPasswordField.sendKeys(String.valueOf(oldPass));
        newPasswordField.sendKeys(String.valueOf(newPass));
        confirmPasswordField.sendKeys(String.valueOf(confirmPass));
    }
    public void pressConfirmButton(){
        confirmButton.click();
    }

}
