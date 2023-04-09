package BaseSetUp;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class BaseSetUp {
    protected WebDriver driver;
    static String driverPath = "/home/sotatek/SELENIUM/chromedriver_linux64";

    public BaseSetUp(String url){
        initializeTestBaseSetup("chrome", url);
    }
    public BaseSetUp(){
    }
    public WebDriver getDriver() {
        return driver;
    }
    private void setDriver(String browserType, String URL) {

        System.out.println("browserType: " + browserType);
        switch (browserType) {
            case "chrome":
                driver = initChromeDriver(URL);
                break;
//            case "firefox":
//                driver = initFirefoxDriver(URL);
//                break;
            default:
                System.out.println("Browser: " + browserType + " is invalid, Launching Chrome as browser of choice...");
                driver = initChromeDriver(URL);
        }
    }

    private WebDriver initChromeDriver(String URL) {
        System.out.println("Launching Chrome browser...");
        System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(URL);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }

//    @BeforeClass
    @Parameters({ "chrome", "http://live.techpanda.org/" })
    public void initializeTestBaseSetup(@Optional("chrome") String browserType,@Optional("http://live.techpanda.org/") String URL) {
        try {
            // Khởi tạo driver và browser
            setDriver(browserType, URL);
        } catch (Exception e) {
            System.out.println("Error..." + e.getStackTrace());
        }
    }
    @AfterTest
    public void tearDown() {
        // Đóng trình duyệt sau khi các phương thức kiểm tra đã thực thi xong
        driver.quit();
    }
}
