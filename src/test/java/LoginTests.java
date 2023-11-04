import core.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.LoginPage;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class LoginTests extends BaseTest {
    WebDriver driver;
    @BeforeTest
    public void init(){
        System.setProperty("webdriver.chrome.driver",downloadPath);

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.manage().window().maximize();
        driver.get("http://localhost/music_mp3/index.php");

    }
    @Test(priority=1)
    public void homePageTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.buttonConnect();
    }
    @Test(priority=2)
    public void loginFailMissUserNameBlank() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputUsername("");
        loginPage.inputPassword("Dz20112001@");
        loginPage.clickSubmitBtn();
        loginPage.testLogin();
    }
    @Test(priority=3)
    public void loginFailMissUser() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputUsername("DinhDuy112233");
        loginPage.inputPassword("Dz20112001@");
        loginPage.clickSubmitBtn();
        loginPage.testLogin();
    }
    @Test(priority=4)
    public void loginFailEmailInvalid() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputUsername("dinhduy899122@gmail.comm132");
        loginPage.inputPassword("Dz20112001@");
        loginPage.clickSubmitBtn();
        loginPage.testLogin();
    }
    @Test(priority=5)
    public void loginFailEmailDoesNotExits() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputUsername("dinhduy986574@gmail.com");
        loginPage.inputPassword("Dz20112001@");
        loginPage.clickSubmitBtn();
        loginPage.testLogin();
    }
    @Test(priority=6)
    public void loginFailMissPassBlank() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputUsername("dinhduy2011");
        loginPage.inputPassword("");
        loginPage.clickSubmitBtn();
        loginPage.testLogin();
    }
    @Test(priority=7)
    public void loginFailMissPassInvalid() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputUsername("dinhduy2011");
        loginPage.inputPassword("!@#!@$!$123");
        loginPage.clickSubmitBtn();
        loginPage.testLogin();
    }
    @Test(priority=8)
    public void loginPass() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputUsername("dinhduy20112001");
        loginPage.inputPassword("Dz20112001@");
        loginPage.clickSubmitBtn();
        loginPage.loginPass();
    }

    @AfterTest
    public void tearDown(){
        driver.close();
    }
}
