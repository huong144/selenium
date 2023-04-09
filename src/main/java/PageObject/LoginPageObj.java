package PageObject;

import AbstractWeb.BaseWebUI;
import PageUI.LoginPageUI;
import org.openqa.selenium.WebDriver;

public class LoginPageObj extends BaseWebUI {
    LoginPageUI loginPageUI;

    public void InvalidEmail() {
        loginPageUI = new LoginPageUI();
        setText(loginPageUI.EMAIL, "");
        setText(loginPageUI.PASSWORD, "123456");
        clickElement(loginPageUI.LOGIN);
        clearText(loginPageUI.EMAIL);
        clearText(loginPageUI.PASSWORD);
    }

    public void InvalidPassword() {
        loginPageUI = new LoginPageUI();
        setText(loginPageUI.EMAIL, "huong14498@gmail.com");
        setText(loginPageUI.PASSWORD, "");
        clickElement(loginPageUI.LOGIN);
        clearText(loginPageUI.EMAIL);
        clearText(loginPageUI.PASSWORD);
    }

    public void Login() {
        loginPageUI = new LoginPageUI();
        setText(loginPageUI.EMAIL, "huong14498@gmail.com");
        setText(loginPageUI.PASSWORD, "123456");
        clickElement(loginPageUI.LOGIN);
    }

    public String getSignInPageTitle() {
        String pageTitle = driver.getTitle();
        return pageTitle;
    }

    public boolean verifySignInPageTitle() {
        String expectedTitle = "My Account";
        return getSignInPageTitle().equals(expectedTitle);
    }

    public LoginPageObj(WebDriver driver) {
        super(driver);
    }
}
