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
        Thread.sleep(4000);
        String currentUrl = webDriver.getCurrentUrl();
        assertEquals("http://dev.account.gopetplan.com/#/Dashboard", currentUrl);
        account.accountArea();
        Thread.sleep(2000);
        String currentUrl1 = webDriver.getCurrentUrl();
        assertEquals("http://dev.account.gopetplan.com/#/MyAccount", currentUrl1);
        account.setOldPassword("asdfghjk");
        account.setNewPassword("password123");
        account.confirmPassword("password123");
        account.updatePassword();
        account.warningMessege();

    }

    @AfterMethod
    private   void afterTest(){
        webDriver.close();
        webDriver.quit();
    }


}
