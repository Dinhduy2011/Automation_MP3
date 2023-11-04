import core.BaseTest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.UpLoadPage;

import java.security.Key;
import java.time.Duration;

import static java.lang.Thread.sleep;

public class UpLoadPageTests extends BaseTest {
    WebDriver driver;

    @BeforeTest
    public void init() {
        System.setProperty("webdriver.chrome.driver", downloadPath);

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // chờ web hiển thị

        driver.manage().window().maximize();
        driver.get("http://localhost/music_mp3/index.php?a=upload");

    }
    @Test(priority=1)
    public void loginPass() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.buttonConnect();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputUsername("dinhduy20112001");
        loginPage.inputPassword("Dz20112001@");
        loginPage.clickSubmitBtn();
    }
    @Test(priority=2)
    public void upLoadFailImageError() throws InterruptedException {
        UpLoadPage upLoad = new UpLoadPage(driver);
        upLoad.UploadImageInvalid();
        upLoad.UploadTrackValid();
        upLoad.inputTitle("");
        upLoad.inputDescription("None");
        upLoad.inputTags("Upload ảnh lỗi");
        upLoad.ClickbtnUploadSubmid();
        upLoad.InvalidIMG();
        upLoad.InputTags.clear();
        upLoad.InputDescription.clear();
    }
    @Test(priority=3)
    public void upLoadFailTitle() throws InterruptedException {
        UpLoadPage upLoad = new UpLoadPage(driver);
        upLoad.UploadImageValid();
        upLoad.UploadTrackValid();
        upLoad.InputTitle.clear();
        upLoad.inputDescription("None");
        upLoad.inputTags("Bỏ trống title");
        upLoad.ClickbtnUploadSubmid();
        upLoad.Title();
        upLoad.InputDescription.clear();
        upLoad.InputTags.clear();
    }
    @Test(priority=4)
    public void upLoadFailTitleMoreThan100C() throws InterruptedException {
        UpLoadPage upLoad = new UpLoadPage(driver);
        upLoad.UploadImageValid();
        upLoad.UploadTrackValid();
        upLoad.InputTitle.clear();
        upLoad.inputTitle("duyduyduyduyduyduyduyduyduyduyduyduyduyduyduyduyduyduyduyduyduyduyduyduyduyduyduyduyduyduyduyduyduyduyduyduyduyduyduyduyduyduyduyduyduyduyduyduyduyduyduyduyduyduyduyduyduyduyduy");
        upLoad.inputDescription("None");
        upLoad.inputTags("Title hơn 100 kí tự");
        upLoad.ClickbtnUploadSubmid();
        upLoad.TitleLength();
        upLoad.InputTitle.clear();
        upLoad.InputDescription.clear();
        upLoad.InputTags.clear();
    }
    @Test(priority=5)
    public void UploadLeaveDesBlank() throws InterruptedException {
        UpLoadPage upLoad = new UpLoadPage(driver);
        upLoad.UploadImageValid();
        upLoad.UploadTrackValid();
        upLoad.inputTitle("Giữ em đi");
        upLoad.inputDescription("");
        upLoad.inputTags("Bỏ trống Description");
        upLoad.ClickbtnUploadSubmid();
        upLoad.UploadSuccess();
        upLoad.InputTitle.clear();
        upLoad.InputDescription.clear();
        upLoad.InputTags.clear();
    }
    @Test(priority=6)
    public void upLoadFailTag() throws InterruptedException {
        UpLoadPage upLoad = new UpLoadPage(driver);
        upLoad.UploadImageValid();
        upLoad.UploadTrackValid();
        upLoad.inputTitle("Giữ em đi");
        upLoad.inputDescription("Bỏ trống Tag");
        upLoad.inputTags("");
        upLoad.ClickbtnUploadSubmid();
        upLoad.Tags();
        upLoad.InputTitle.clear();
        upLoad.InputDescription.clear();
        upLoad.InputTags.clear();
    }
    @Test(priority=7)
    public void upLoadFailTagMoreThan26C() throws InterruptedException {
        UpLoadPage upLoad = new UpLoadPage(driver);
        upLoad.UploadImageValid();
        upLoad.UploadTrackValid();
        upLoad.inputTitle("Giữ em đi");
        upLoad.inputDescription("Tag hơn 26 kí tự");
        upLoad.inputTags("Đồ án tốt nghiệp Đồ án tốt nghiệp Đồ án tốt nghiệp Đồ án tốt nghiệp Đồ án tốt nghiệp ");
        upLoad.ClickbtnUploadSubmid();
        upLoad.TitleLength();
        upLoad.InputTitle.clear();
        upLoad.InputDescription.clear();
        upLoad.InputTags.clear();
    }
    @Test(priority=8)
    public void upLoadFailTrackError() throws InterruptedException {
        UpLoadPage upLoad = new UpLoadPage(driver);
        upLoad.UploadImageValid();
      //  upLoad.UploadTrackValid();
        upLoad.UploadTrackInvalid();
        upLoad.inputDescription("UploadFailTrack");
        upLoad.inputTags("");
        upLoad.ClickbtnUploadSubmid();
        upLoad.InputDescription.clear();
        upLoad.InvalidTrack();
        upLoad.InputTitle.clear();
        upLoad.InputDescription.clear();
    }
    @Test(priority=7)
    public void UploadSuccess() throws InterruptedException {
        UpLoadPage upLoad = new UpLoadPage(driver);
        upLoad.UploadImageValid();
        upLoad.UploadTrackValid();
        upLoad.inputTitle("Giữ em đi");
        upLoad.inputDescription("None");
        upLoad.inputTags("Đồ án tốt nghiệp");
        upLoad.ClickbtnUploadSubmid();
        upLoad.UploadSuccess();
   }
    @AfterTest
    public void tearDown(){
        driver.close();
    }
}
