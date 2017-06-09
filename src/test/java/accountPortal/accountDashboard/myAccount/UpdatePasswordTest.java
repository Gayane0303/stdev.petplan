package accountPortal.accountDashboard.myAccount;

import core.Driver;
import core.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObject.accountPortal.accountDashboard.myAccount.MyAccountPageOject;
import pageObject.accountPortal.login.LoginPageObject;
import pageObject.accountPortal.xpaths.Xpaths;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class UpdatePasswordTest {
    private Driver driver = new Driver();
    private WebDriver webDriver;
    private MyAccountPageOject account;
    private LoginPageObject login;
    private Wait wait;
    private Xpaths xpaths;

    private void NavigateAccountArea() throws InterruptedException {
        account.accountArea();
        Thread.sleep(2000);
        String currentUrl1 = webDriver.getCurrentUrl();
        assertEquals("http://dev.account.gopetplan.com/#/MyAccount", currentUrl1);
    }

    @BeforeMethod
    private  void beforeTest(){
        wait = new Wait();
        xpaths = new Xpaths();
        webDriver = driver.getDriver();
        login=new LoginPageObject(webDriver);
        account=new MyAccountPageOject(webDriver);
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        login.login("stdevqatest@mailinator.com","password123","check");
    }

    @Test()
    public void UpdatingPasswordWithWrongOldPassword() throws InterruptedException {
        Thread.sleep(2000);
        String currentUrl = webDriver.getCurrentUrl();
        assertEquals("http://dev.account.gopetplan.com/#/Login", currentUrl);
        NavigateAccountArea();
        account.setOldPassword("asdfghjk");
        account.setNewPassword("password123");
        account.confirmPassword("password123");
        account.updatePassword();
        account.warningMessege();
    }

    @Test()
    public void EmptyConfirmPasswordField() throws InterruptedException {
        NavigateAccountArea();
        account.updatePassword();
        account.warningMessegeConfirm();
        account.warningMessegeNew();
        account.warningMessegeOld();
        account.setOldPassword("password123");
        account.updatePassword();
        account.warningMessegeConfirm();
        account.warningMessegeNew();
        account.setNewPassword("asdasdasd");
        account.updatePassword();
        account.warningMessegeConfirm();
    }

    @Test()
    public void  NotMatchingPassword() throws InterruptedException {
        NavigateAccountArea();
        account.setOldPassword("password123");
        account.setNewPassword("hello");
        account.confirmPassword("asdasdadad");
        account.noMatchConfirm();
        account.updatePassword();
        account.noMatchConfirm();
    }



    @AfterMethod
    private   void afterTest(){
        webDriver.close();
        webDriver.quit();
    }


}
