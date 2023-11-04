import core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobjects.FilePage;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.UpLoadPage;

import java.time.Duration;

public class FileTests extends BaseTest {
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
    public void backGroundTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        UpLoadPage upLoadPage = new UpLoadPage(driver);
        homePage.buttonConnect();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputUsername("dinhduy20112001");
        loginPage.inputPassword("Dz20112001@");
        loginPage.clickSubmitBtn();
        upLoadPage.buttonUpLoad();
    }


    @Test(priority=2)
    public void fileTest() throws InterruptedException {
        FilePage filePage = new FilePage(driver);
        UpLoadPage upLoad = new UpLoadPage(driver);
        upLoad.UploadImageValid();
        upLoad.UploadTrackValid();
        upLoad.inputTitle("Giữ em đi");
        upLoad.inputDescription("None");
        upLoad.inputTags("Đồ án tốt nghiệp");

        filePage.getData();
    }

    @AfterTest
    public void tearDown(){
        driver.close();
    }
}
