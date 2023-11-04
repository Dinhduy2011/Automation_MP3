import core.BaseTest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.ListMusicPage;
import pageobjects.LoginPage;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class ListMusicPageTests extends BaseTest {
    WebDriver driver;

    @BeforeTest
    public void init() {
        System.setProperty("webdriver.chrome.driver", downloadPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://localhost/music_mp3/index.php?a=explore&filter=popular%20music");
    }
    @Test(priority=1)
    public void loginPass() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.buttonConnect();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputUsername("dinhduy20112001"); // dinhduy20112001
        loginPage.inputPassword("Dz20112001");  // Dz20112001@
        loginPage.clickSubmitBtn();
    }
    @Test(priority=2)
    public void TestTime() throws InterruptedException {
        ListMusicPage listMusicPage = new ListMusicPage(driver);
        listMusicPage.Second();
    }
    @Test(priority=2)
    public void popularMusic() throws InterruptedException {
        ListMusicPage listMusicPage = new ListMusicPage(driver);
        listMusicPage.popular();
        listMusicPage.playMusic();
    }
    @Test(priority=3)
    public void deleteCancle() throws InterruptedException {
        ListMusicPage listMusicPage = new ListMusicPage(driver);
        sleep(2000);
        listMusicPage.deleteCancel();
    }
    @Test(priority=4)
    public void delete() throws InterruptedException {
        ListMusicPage listMusicPage = new ListMusicPage(driver);
        sleep(2000);
        listMusicPage.delete();
    }
    @AfterTest
    public void tearDown(){
        driver.close();
    }
}
