package pageObject.accountPortal.xpaths;

import org.openqa.selenium.By;


public class Xpaths {
    //change password
    public final By accountArea = By.xpath("//span[text()='account area']");
    public final By oldPassword = By.xpath("//input[@name='oldPassword']");
    public final By newPassword = By.xpath("//input[@name='newPassword']");
    public final By confirmPassword = By.xpath("//input[@name='confirmPassword']");
    public final By updatePasswordButton = By.xpath("//button[contains(text(),   'update password')] ");
    public final By messegeOfChangePassword = By.xpath("//p[text()='Your password has been successfully updated.']");
    public final By signOut = By.xpath("//span[text()='sign out']");
    public final By signIn = By.xpath("//button[@class='btn__link--primary']");
    public final By validationMessege = By.xpath("//p[@class='validation-message ng-scope']");
    public final By verifyLogged = By.xpath("//h4[text()='Test Account']");
    public final By warningMessege = By.xpath("//p[text()='Wrong password, please try again.']");

}
