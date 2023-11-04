package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class BaseTest {
    private WebDriver driver;

    public static String downloadPath =  System.getProperty("user.dir")+"\\driver\\chromedriver.exe";
//    public static String downloadPath2 =  System.getProperty("user.dir")+"\\driver\\geckodriver.exe";
    @BeforeTest
    public void init(){
        System.setProperty("webdriver.chrome.driver",downloadPath);
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
//    public void init2(){
//        System.setProperty("webdriver.firefox.driver",downloadPath2);
//        WebDriver driver = new FirefoxDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().window().maximize();
//    }
    public WebDriver getDriver() {
        return driver;
    }
    @AfterTest
    public void tearDown(){
        driver.close();
    }
}
