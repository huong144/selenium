package PageUI;

import org.openqa.selenium.By;

public class LoginPageUI {
    public static By EMAIL = By.xpath("//input[@id='email']");
    public static  By PASSWORD = By.id("pass");
    public static  By LOGIN = By.xpath("//button[@name='send']");
    public static By INVALID_LOGIN = By.xpath("//span[normalize-space()='Invalid login or password.']");
}
