package pageobjects;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import static java.lang.Thread.sleep;

public class ProgressBarPage extends BasePage {
    public ProgressBarPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='page-header page-header-extra']")
    private WebElement textPopular;
    @FindBy(xpath = "//div[@id='song-name5']")
    private WebElement textMusic1;
    @FindBy(xpath = "//div[@id='song-name4']")
    private WebElement textMusic2;
    @FindBy(id = "play4")
    private WebElement btnJpPlay;
    @FindBy(xpath = "//a[@title='Pause']")
    private WebElement btnJpPlayRun;
    @FindBy(xpath = "//a[@id='song-author4']")
    private WebElement btnUser;
    @FindBy(xpath = "//div[@id='song-name4']")
    private WebElement nameMusic;
    @FindBy(xpath = "//div[@id='track4']//div[@class='jp-seek-bar']")
    private WebElement tagBar;
    @FindBy(xpath = "//div[@id='doLike4']//span[@class='action-text'][normalize-space()='Like']")
    private WebElement btnLike;
    @FindBy(xpath = "//div[@id='track-action4']//span[@class='action-text'][normalize-space()='Add']")
    private WebElement btnAdd;
    @FindBy(xpath = "//div[@id='track-action3']//span[@class='action-text'][normalize-space()='Share']")
    private WebElement btnShare;
    @FindBy(xpath = "//div[@id='current-time']")
    private WebElement currentTime;
    @FindBy(xpath = "//a[@title='Repeat']")
    private WebElement btnRepeat;
    @FindBy(xpath = "//a[@title='Mute']")
    private WebElement btnMute;
    @FindBy(xpath = "//a[@title='Unmute']")
    private WebElement btnUnMute;
    @FindBy(xpath = "//div[@title='Volume']")
    private WebElement btnVolume;
    @FindBy(xpath = "//a[@id='next-button']")
    private WebElement btnNext;
    @FindBy(xpath = "//a[@id='prev-button']")
    private WebElement btnPrev;
    public void playMusic() throws InterruptedException {
        btnJpPlay.click();
        sleep(5000);
        btnJpPlayRun.click();
        String ActualText = currentTime.getText();
        String ExpectedText= "00:00";
        Assert.assertNotEquals(ExpectedText, ActualText);
        System.out.println("The song is playing " + ActualText +" second");
    }
    public void mute() throws InterruptedException {
        btnMute.click();
        System.out.println("Muted sound successfully");
        sleep(4000);
        btnUnMute.click();
        System.out.println("Sound turned on successfully");
        sleep(4000);
    }
    public void repeat() throws InterruptedException {
        driver.navigate().to("http://localhost/music_mp3/index.php?a=explore&filter=popular%20music");
        btnJpPlay.click();
        btnRepeat.click();
        sleep(10000);
        btnJpPlayRun.click();
        String ActualText = currentTime.getText();
        String ExpectedText= "00:00";
        Assert.assertNotEquals(ExpectedText, ActualText);
        System.out.println("The song was played again");
    }
    public void draganddropby() throws InterruptedException {
        driver.navigate().to("http://localhost/music_mp3/index.php?a=explore&filter=popular%20music");
        btnJpPlay.click();
        sleep(3000);
        Actions move = new Actions(driver);
        Action action = (Action) move.dragAndDropBy(btnVolume, -20, 0).build();
        action.perform();
        sleep(3000);
        Actions move1 = new Actions(driver);
        Action action1 = (Action) move1.dragAndDropBy(btnVolume, 20, 0).build();
        action1.perform();
        System.out.println("Sound test successful");
        // có 1 số case không thể check bằng auto , đây là 1 ví dụ , chỉ có giác quan của con người mới nhận biết lời bài hát
    }
    public void nextButton() throws InterruptedException {
        btnNext.click();
        String ActualText = textMusic1.getText();
        String ExpectedText= "Hon Ca Yeu - Duc Phuc";
        Assert.assertEquals(ExpectedText, ActualText);
        System.out.println("The song is playing " + ActualText);
        sleep(5000);
    }
    public void prevButton() throws InterruptedException {
        btnPrev.click();
        String ActualText = textMusic2.getText();
        String ExpectedText= "QuenMotNguoiThuongEm-PhatHoNHA-10715767";
        Assert.assertEquals(ExpectedText, ActualText);
        System.out.println("The song is playing " + ActualText);
        sleep(5000);
    }
}
