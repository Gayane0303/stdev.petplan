package accountPortal.accountDashboard.myAccount;

import core.Driver;
import core.Wait;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObject.accountPortal.accountDashboard.myAccount.MyAccountPageOject;
import pageObject.accountPortal.login.LoginPageObject;

import java.util.concurrent.TimeUnit;

public class UpdatePasswordTest {
    private Driver driver = new Driver();
    private WebDriver webDriver;
    private MyAccountPageOject account;
    private LoginPageObject login;
    private Wait wait;

    @BeforeMethod
    private  void beforeTest(){
        wait = new Wait();
        webDriver = driver.getDriver();
        login=new LoginPageObject(webDriver);
        account=new MyAccountPageOject(webDriver);
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        login.login("stdevqatest@mailinator.com","password123","check");
    }
    @AfterMethod
    private   void afterTest(){
        webDriver.close();
        webDriver.quit();
    }
    @Test()
    public void updatingPassword(){
    }
}
