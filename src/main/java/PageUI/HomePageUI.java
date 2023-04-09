package PageUI;

import org.openqa.selenium.By;

public class HomePageUI {
    public static By ACCOUNT = By.xpath("//span[@class='label'][normalize-space()='Account']");
    public static By MY_ACCOUNT = By.xpath("//div[@id='header-account']//a[@title='My Account'][normalize-space()='My Account']");
    public static By MY_WISHLIST = By.xpath("//a[normalize-space()='My Wishlist']");
    public static By MY_CART = By.xpath("//a[normalize-space()='My Cart']");
    public static By CHECKOUT = By.xpath("//a[normalize-space()='Checkout']");
    public static By REGISTER = By.xpath("//a[normalize-space()='Register']");
    public static By LOGIN = By.xpath("//a[normalize-space()='Log In']");
    public static By CART = By.xpath("//span[normalize-space()='Cart']");
    public static By SEARCH = By.xpath("//input[@id='search']");
}
