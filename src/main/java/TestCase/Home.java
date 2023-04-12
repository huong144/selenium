package TestCase;

import BaseSetUp.BaseSetUp;
import BaseSetUp.BaseUrl;
import PageUI.HomePageUI;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Home extends BaseSetUp {
    HomePageUI homePageUI;

    public Home(){
        super(new BaseUrl().homeUrl);
    }

    @Test(priority = 1)
    public void Home() {
        homePageUI = new HomePageUI();
        driver.findElement(homePageUI.ACCOUNT).click();
        driver.findElement(homePageUI.REGISTER).click();
        System.out.println("driver.getCurrentUrl(): " + driver.getCurrentUrl());
        driver.get(driver.getCurrentUrl());
    }

    @AfterTest
    public void tearDown() {
        // Đóng trình duyệt sau khi các phương thức kiểm tra đã thực thi xong
        driver.quit();
    }
}
