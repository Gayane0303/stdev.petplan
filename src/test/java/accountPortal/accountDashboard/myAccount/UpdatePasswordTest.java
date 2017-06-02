package accountPortal.accountDashboard.myAccount;

import core.Driver;
import core.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObject.accountPortal.HomePage.HomePage;
import pageObject.accountPortal.accountDashboard.myAccount.MyAccountPage;
import pageObject.accountPortal.login.LoginPageObject;

import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertTrue;
import static org.testng.Assert.assertFalse;

public class UpdatePasswordTest {
    private Driver driver = new Driver();
    private WebDriver webDriver;
    private MyAccountPage accountPage;
    private HomePage homePage;
    private LoginPageObject login;
    private Wait wait;
    private String email = "TestQA111@mailinator.com";
    private String password = "Test123";
    private String remember = "check";

    
    @BeforeMethod
    private  void beforeTest(){
        wait = new Wait();
        webDriver = driver.getDriver();
        login=new LoginPageObject(webDriver);
        homePage = new HomePage(webDriver);
        accountPage=new MyAccountPage(webDriver);
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        login.login(email,password,remember);
        wait.waitForPageLoad(webDriver);
    }

    @AfterMethod
    private   void afterTest(){
        webDriver.close();
        webDriver.quit();
    }
    private boolean isElementPresent(WebElement webElement){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return webElement.isDisplayed();
    }
    @Test()
    public void updatingPassword65(){
        String newPassword = "Test1234";
        homePage.openMyAccountArea();
        assertTrue(isElementPresent(accountPage.confirmButton));
        accountPage.changePassword(password,newPassword,newPassword);
        assertTrue(isElementPresent(accountPage.successfullUpdateMsg));
        accountPage.changePassword(newPassword,password,password);
        assertTrue(isElementPresent(accountPage.successfullUpdateMsg));
    }

    @Test()
    public void inputWrongOldPassword23(){
        String password = "Test1234";
        homePage.openMyAccountArea();
        assertTrue(isElementPresent(accountPage.confirmButton));
        accountPage.changePassword(password,password,password);
        assertTrue(isElementPresent(accountPage.wrongOldPassMsg));
    }
    @Test()
    public void testWithEmptyData24() {
        homePage.openMyAccountArea();
        assertTrue(isElementPresent(accountPage.confirmButton));
        accountPage.pressConfirmButton();
        assertTrue(isElementPresent(accountPage.requiredFieldMsg));
    }
    @Test()
    public void testWrongConfirmPassword27() {
        String password1 = "Test1234";
        String password2 = "Test12345";
        homePage.openMyAccountArea();
        assertTrue(isElementPresent(accountPage.confirmButton));
        accountPage.changePassword(password,password1,password2);
        assertTrue(isElementPresent(accountPage.wrongConfirmPassMsg));
    }
//
    @Test()
    public void testShortNewPassword55() {
        String newPassword = "Test";
        homePage.openMyAccountArea();
        assertTrue(isElementPresent(accountPage.confirmButton));
        accountPage.changePassword(password,newPassword,newPassword);
        assertTrue(isElementPresent(accountPage.shortNewPassMsg));
    }
    @Test()
    public void testLongNewPassword62() {
        String newPassword = "TestTestTestTestTestTest";
        homePage.openMyAccountArea();
        assertTrue(isElementPresent(accountPage.confirmButton));
        accountPage.changePassword(password,newPassword,newPassword);
        assertTrue(isElementPresent(accountPage.shortNewPassMsg));
    }
    @Test()
    public void testSamePassword66() {
        homePage.openMyAccountArea();
        assertTrue(isElementPresent(accountPage.confirmButton));
        accountPage.changePassword(password,password,password);
        assertFalse(isElementPresent(accountPage.successfullUpdateMsg));
    }
}
