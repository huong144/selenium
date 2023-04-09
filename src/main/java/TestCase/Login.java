package TestCase;

import BaseSetUp.BaseSetUp;
import PageObject.LoginPageObj;
import PageUI.LoginPageUI;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


public class Login extends BaseSetUp {
    LoginPageObj loginPageObj;
    public Login(){
        super("http://live.techpanda.org/index.php/customer/account/login");
    }
    @Test(priority = 1)
    public void LoginWithInvalidEmail(){

        System.out.println(getDriver().getCurrentUrl());
        loginPageObj = new LoginPageObj(getDriver());
        loginPageObj.InvalidEmail();
        Assert.assertEquals(driver.findElement(By.id("advice-required-entry-email")).getText(), "This is a required field.");
    }

    @Test(priority = 2)
    public void LoginWithInvalidPassword(){
        loginPageObj = new LoginPageObj(getDriver());
        loginPageObj.InvalidPassword();
        Assert.assertEquals(driver.findElement(By.id("advice-required-entry-pass")).getText(), "This is a required field.");
    }

    @Test(priority = 3)
    public void TestLogin() {
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
