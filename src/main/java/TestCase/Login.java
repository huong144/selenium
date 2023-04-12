package TestCase;

import BaseSetUp.BaseSetUp;
import BaseSetUp.BaseUrl;
import PageObject.LoginPageObj;
import PageUI.LoginPageUI;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


public class Login extends BaseSetUp {
    LoginPageObj loginPageObj;

    public Login() {

        super(new BaseUrl().homeUrl + "/index.php/customer/account/login");
    }

    @Test(priority = 1)
    public void LoginInvalidEmailPassword() {
        loginPageObj = new LoginPageObj(getDriver());
        loginPageObj.InvalidEmailAndPass();
        Assert.assertEquals(driver.findElement(By.id("advice-required-entry-email")).getText(), "This is a required field.");
        Assert.assertEquals(driver.findElement(By.id("advice-required-entry-pass")).getText(), "This is a required field.");
    }

    @Test(priority = 2)
    public void LoginWithInvalidEmail() {
        loginPageObj = new LoginPageObj(getDriver());
        loginPageObj.InvalidEmail();
        Assert.assertEquals(driver.findElement(By.id("advice-required-entry-email")).getText(), "This is a required field.");
    }

    @Test(priority = 3)
    public void LoginWithInvalidPassword() {
        loginPageObj = new LoginPageObj(getDriver());
        loginPageObj.InvalidPassword();
        Assert.assertEquals(driver.findElement(By.id("advice-required-entry-pass")).getText(), "This is a required field.");
    }

    @Test(priority = 4)
    public void LogiInvalid() {
        loginPageObj = new LoginPageObj(getDriver());
        loginPageObj.Invalid();
        Assert.assertTrue(loginPageObj.CheckLogin());
        {
            driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
        }

    }

    @Test(priority = 5)
    public void TestLogin() {
        driver.get(new BaseUrl().homeUrl + "/index.php/customer/account/login");
        loginPageObj = new LoginPageObj(getDriver());
        loginPageObj.Login();
        Assert.assertTrue(loginPageObj.verifySignInPageTitle(), "Login successfully");
    }

//    @AfterTest
//    public void tearDown() {
//        // Đóng trình duyệt sau khi các phương thức kiểm tra đã thực thi xong
//        driver.quit();
//    }
}
