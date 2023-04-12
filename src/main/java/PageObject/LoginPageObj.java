package PageObject;

import AbstractWeb.BaseWebUI;
import PageUI.LoginPageUI;
import org.openqa.selenium.WebDriver;

public class LoginPageObj extends BaseWebUI {
    LoginPageUI loginPageUI;

    public void InvalidEmail() {
        setValueLogin("", "123456");
        ActionLogin();
    }

    public void InvalidPassword() {
        setValueLogin("huong14498@gmail.com", "");
        ActionLogin();
    }

    public void InvalidEmailAndPass(){
        setValueLogin("", "");
        ActionLogin();
    }

    public void Invalid(){
        setValueLogin("1111@gmail.com", "1111111");
        ActionLogin();
    }
    public void Login() {
        setValueLogin("huong14498@gmail.com", "123456");
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

    private void ActionLogin() {
        clearText(loginPageUI.EMAIL);
        clearText(loginPageUI.PASSWORD);
    }

    private void setValueLogin(String email, String password) {
        loginPageUI = new LoginPageUI();
        setText(loginPageUI.EMAIL, email);
        setText(loginPageUI.PASSWORD, password);
        clickElement(loginPageUI.LOGIN);
    }

    public String getText() {
        String pageText = driver.findElement(loginPageUI.INVALID_LOGIN).getText();
        return pageText;
    }
    public boolean CheckLogin(){
        String expectedResult = "Invalid login or password.";
        return getText().equals(expectedResult);
    }
}
