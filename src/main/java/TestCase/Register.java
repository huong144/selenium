package TestCase;

import BaseSetUp.BaseSetUp;
import BaseSetUp.BaseUrl;
import PageObject.LoginPageObj;
import PageObject.RegisterPageObj;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Register extends BaseSetUp {
    RegisterPageObj registerPageObj;
    public Register() {
        super( new BaseUrl().homeUrl + "/index.php/customer/account/create");
    }

    @Test
    public void RegisterInvalid(){
        registerPageObj = new RegisterPageObj(getDriver());
        registerPageObj.Invalid();
        Assert.assertEquals(driver.findElement(By.id("advice-required-entry-firstname")).getText(), "This is a required field.");
        Assert.assertEquals(driver.findElement(By.id("advice-required-entry-lastname")).getText(), "This is a required field.");
        Assert.assertEquals(driver.findElement(By.id("advice-required-entry-email_address")).getText(), "This is a required field.");
        Assert.assertEquals(driver.findElement(By.id("advice-required-entry-password")).getText(), "This is a required field.");
        Assert.assertEquals(driver.findElement(By.id("advice-required-entry-confirmation")).getText(), "This is a required field.");
    }
    @Test
    public void TestRegister() {
        registerPageObj = new RegisterPageObj(getDriver());
        registerPageObj.Register();
//        Assert.assertTrue(registerPageObj.verifySignInPageTitle(), "Login successfully");
    }

}
