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
import pageobjects.ProgressBarPage;

import java.time.Duration;

public class ProgressBarTests extends BaseTest {
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
    public void popularplayMusic() throws InterruptedException {
        ProgressBarPage progressBarPage = new ProgressBarPage(driver);
        progressBarPage.playMusic();
    }
    @Test(priority=2)
    public void popularMute() throws InterruptedException {
        ProgressBarPage progressBarPage = new ProgressBarPage(driver);
        progressBarPage.mute();
    }
    @Test(priority=3)
    public void popularRepeat() throws InterruptedException {
        ProgressBarPage progressBarPage = new ProgressBarPage(driver);
        progressBarPage.repeat();
    }
    @Test(priority=4)
    public void popularDraganddropby() throws InterruptedException {
        ProgressBarPage progressBarPage = new ProgressBarPage(driver);
        progressBarPage.draganddropby();
    }
    @Test(priority=5)
    public void popularNextButton() throws InterruptedException {
        ProgressBarPage progressBarPage = new ProgressBarPage(driver);
        progressBarPage.nextButton();
    }
    @Test(priority=6)
    public void popularPrevButton() throws InterruptedException {
        ProgressBarPage progressBarPage = new ProgressBarPage(driver);
        progressBarPage.prevButton();
    }
    @AfterTest
    public void tearDown(){
        driver.close();
    }
}
