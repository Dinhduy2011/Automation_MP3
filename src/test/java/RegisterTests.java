import core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.RegisterPage;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class RegisterTests extends BaseTest {
    WebDriver driver;

    @BeforeTest
    public void init() {
        System.setProperty("webdriver.chrome.driver", downloadPath);

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.manage().window().maximize();
        driver.get("http://localhost/music_mp3/index.php");

    }

    @Test(priority=1)
    public void homePageTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.buttonConnect();
        homePage.buttonRegister();
    }

    @Test(priority=2)
    public void registerFailMissUserBlank() throws InterruptedException {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.inputUsername("");
        registerPage.inputPassword("Dz20112001@");
        registerPage.inputEmail("dinhduy202112001@gmail.com");
        registerPage.clickRegisterBtn();
        registerPage.testRegister();
    }
    @Test(priority=3)
    public void registerFailInputUserThan33C() throws InterruptedException {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.inputUsername("duyduyduyduyduyduyduyduyduyduyduyy");
        registerPage.inputPassword("Dz20112001@");
        registerPage.inputEmail("dinhduy202112001@gmail.com");
        registerPage.clickRegisterBtn();
        registerPage.testRegister();
    }
    @Test(priority=4)
    public void registerFailInputUserLess2C() throws InterruptedException {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.inputUsername("Du");
        registerPage.inputPassword("Dz20112001@");
        registerPage.inputEmail("dinhduy202112001@gmail.com");
        registerPage.clickRegisterBtn();
        registerPage.testRegister();
    }
    @Test(priority=5)
    public void registerFailInputUserSpecialCharacter() throws InterruptedException {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.inputUsername("@@@***");
        registerPage.inputPassword("Dz20112001@");
        registerPage.inputEmail("dinhduy202112001@gmail.com");
        registerPage.clickRegisterBtn();
        registerPage.testRegister();
    }
    @Test(priority=6)
    public void registerFailMissPassBlank() throws InterruptedException {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.inputUsername("Dinhduy2000");
        registerPage.inputPassword("");
        registerPage.inputEmail("dinhduy202112001@gmail.com");
        registerPage.clickRegisterBtn();
        registerPage.testRegister();
    }
    @Test(priority=7)
    public void registerFailInputPass1C() throws InterruptedException {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.inputUsername("Dinhduy2002");
        registerPage.inputPassword("D");
        registerPage.inputEmail("dinhduy202112001@gmail.com");
        registerPage.clickRegisterBtn();
        registerPage.testRegister();
    }
    @Test(priority=8)
    public void registerFailInputPass5C() throws InterruptedException {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.inputUsername("Dinhduy100");
        registerPage.inputPassword("D1234");
        registerPage.inputEmail("dinhduy202112001@gmail.com");
        registerPage.clickRegisterBtn();
        registerPage.testRegister();
    }
    @Test(priority=9)
    public void registerFailInputPass31C() throws InterruptedException {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.inputUsername("Dinhduy101");
        registerPage.inputPassword("DuyDuyDuyDuyDuyDuyDuyDuyDuyDuy123");
        registerPage.inputEmail("dinhduy202112001@gmail.com");
        registerPage.clickRegisterBtn();
        registerPage.testRegister();
    }
    @Test(priority=10)
    public void registerFailInputPassMissingnumbers() throws InterruptedException {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.inputUsername("Dinhduy102");
        registerPage.inputPassword("Dinhduy@@");
        registerPage.inputEmail("dinhduy202112001@gmail.com");
        registerPage.clickRegisterBtn();
        registerPage.testRegister();
    }
    @Test(priority=11)
    public void registerFailInputPassMissingUperCase() throws InterruptedException {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.inputUsername("Dinhduy103");
        registerPage.inputPassword("dinhduy!@#123");
        registerPage.inputEmail("dinhduy202112001@gmail.com");
        registerPage.clickRegisterBtn();
        registerPage.testRegister();
    }
    @Test(priority=12)
    public void registerFailInputPassMissingLowCase() throws InterruptedException {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.inputUsername("Dinhduy104");
        registerPage.inputPassword("DINHDUY!123");
        registerPage.inputEmail("dinhduy202112001@gmail.com");
        registerPage.clickRegisterBtn();
        registerPage.testRegister();
    }
    @Test(priority=13)
    public void registerFailInputPassMissingSpecialCharacter() throws InterruptedException {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.inputUsername("Dinhduy105");
        registerPage.inputPassword("Dinhduy123");
        registerPage.inputEmail("dinhduy202112001@gmail.com");
        registerPage.clickRegisterBtn();
        registerPage.testRegister();
    }
    @Test(priority=14)
    public void registerFailMissEmailBlank() throws InterruptedException {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.inputUsername("Dinhduy106");
        registerPage.inputPassword("Dz20112001@");
        registerPage.inputEmail("");
        registerPage.clickRegisterBtn();
        registerPage.testRegister();
    }
    @Test(priority=15)
    public void registerFailMissEmail() throws InterruptedException {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.inputUsername("Dinhduy107");
        registerPage.inputPassword("Dz20112001@");
        registerPage.inputEmail("Dinhduy2011");
        registerPage.clickRegisterBtn();
        registerPage.testRegister();
    }
    @Test(priority=16)
    public void registerPass() throws InterruptedException {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.inputUsername("Dinhduy9122");
        registerPage.inputPassword("Dz20112001@");
        registerPage.inputEmail("dinhduy202112001@gmail.com");
        registerPage.clickRegisterBtn();
        registerPage.registerPass();
    }
    @AfterTest
    public void tearDown(){
        driver.close();
    }
}
