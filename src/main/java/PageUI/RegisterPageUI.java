package PageUI;

import org.openqa.selenium.By;

public class RegisterPageUI {
    public static By FIRST_NAME = By.xpath("//input[@id='firstname']");
    public static By MIDDLE_NAME = By.xpath("//input[@id='middlename']");
    public static By LAST_NAME = By.xpath("//input[@id='lastname']");
    public static By EMAIL = By.xpath("//input[@id='email_address']");
    public static By PASSWORD = By.xpath("//input[@id='password']");
    public static By CONFIRM_PASSWORD = By.xpath("//input[@id='confirmation']");
    public static By REGISTER = By.xpath("//span[contains(text(),'Register')]");
}