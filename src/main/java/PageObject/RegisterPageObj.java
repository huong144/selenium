package PageObject;

import AbstractWeb.BaseWebUI;
import PageUI.LoginPageUI;
import PageUI.RegisterPageUI;
import org.openqa.selenium.WebDriver;

public class RegisterPageObj extends BaseWebUI {

    RegisterPageUI registerPageUI;
    public RegisterPageObj(WebDriver driver) {
        super(driver);
    }

    private void SetValueRegister(String firstName, String middleName, String lastName, String email, String password, String confirmPassword) {
        registerPageUI = new RegisterPageUI();
        setText(registerPageUI.FIRST_NAME,firstName);
        setText(registerPageUI.MIDDLE_NAME,middleName);
        setText(registerPageUI.LAST_NAME,lastName);
        setText(registerPageUI.EMAIL,email);
        setText(registerPageUI.PASSWORD,password);
        setText(registerPageUI.CONFIRM_PASSWORD,confirmPassword);
        clickElement(registerPageUI.REGISTER);
    }

    private void ActionRegister() {
        clearText(registerPageUI.FIRST_NAME);
        clearText(registerPageUI.MIDDLE_NAME);
        clearText(registerPageUI.LAST_NAME);
        clearText(registerPageUI.EMAIL);
        clearText(registerPageUI.PASSWORD);
        clearText(registerPageUI.CONFIRM_PASSWORD);
    }

    public void Invalid(){
        SetValueRegister("", "", "", "", "","");
        ActionRegister();
    }
    public void InvalidFirstName(){
        SetValueRegister("", "Thu", "Huong", "huong14498+3@gmail.com", "123456","123456");
        ActionRegister();
    }
    public void InvalidMiddleName(){
        SetValueRegister("Bui", "", "Huong", "huong14498+3@gmail.com", "123456","123456");
        ActionRegister();
    }

    public void InvalidLassName(){
        SetValueRegister("Bui", "Thu", "", "huong14498+3@gmail.com", "123456","123456");
        ActionRegister();
    }

    public void InvalidEmail(){
        SetValueRegister("Bui", "Thu", "Huong", "", "123456","123456");
        ActionRegister();
    }
    public void InvalidPassword(){
        SetValueRegister("Bui", "Thu", "Huong", "huong14498+3@gmail.com", "","123456");
        ActionRegister();
    }

    public void InvalidConfirmPassword(){
        SetValueRegister("Bui", "Thu", "Huong", "huong14498+3@gmail.com", "123456","");
        ActionRegister();
    }
    public void Register(){
        SetValueRegister("Bui", "Thu", "Huong", "huong14498+3@gmail.com", "123456","123456");
    }

}
