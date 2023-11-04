import core.BaseTest;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.ListMusicPage;
import pageobjects.LoginPage;
import pageobjects.RegisterPage;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class HomePageTests extends BaseTest {
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
    public void searchFailWhenInputOnlyNumber() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.searchFail("123465789" + Keys.ENTER);
        homePage.returnHome();
    }
    @Test(priority=2)
    public void searchFailWhenInputUpercaseLowCase() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.search("HƠN CẢ yêu" + Keys.ENTER);
        homePage.returnHome();
    }
    @Test(priority=3)
    public void searchFailWhenInputOnlySpecialCharacer() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.searchFail("♥♥♥♥♥♥" + Keys.ENTER);
        homePage.returnHome();
    }
    @Test(priority=4)
    public void searchTestWhenInputAPartOfContent() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.search("Hon Ca" + Keys.ENTER);
        homePage.returnHome();
    }
    @Test(priority=5)
    public void searchTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.search("hon ca yeu" + Keys.ENTER);
        homePage.returnHome();
    }
    @Test(priority=6)
    public void hoverJoinNow() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.hoverJoinNow();
    }
    @Test(priority=7)
    public void clickJoinNow() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.buttonJoinNow();
        LoginPage loginPage =new LoginPage(driver);
        loginPage.loginHome();
    }
    @Test(priority=8)
    public void playMusic() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.play();
    }
    @Test(priority=9)
    public void exploreScreen() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.explore();
        homePage.returnHome();
    }
    @Test(priority=10)
    public void popularScreen() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.popular();
    }
    @AfterTest
    public void tearDown(){
        driver.close();
    }
}
