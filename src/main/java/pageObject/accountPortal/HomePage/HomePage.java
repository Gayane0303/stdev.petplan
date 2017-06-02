package pageObject.accountPortal.HomePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObject.accountPortal.accountDashboard.myAccount.MyAccountPage;

/**
 * Created by liana on 6/1/17.
 */
public class HomePage {
    @FindBy(xpath = "//a[@href='#/MyAccount']")
    private WebElement accontArea;
    private WebDriver webDriver;

    public HomePage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    public MyAccountPage openMyAccountArea(){
        accontArea.click();
        return new MyAccountPage(webDriver);
    }
}
