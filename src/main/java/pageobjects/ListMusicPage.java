package pageobjects;

import core.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.time.LocalDateTime;

import static java.awt.SystemColor.window;
import static java.lang.Thread.sleep;

public class ListMusicPage extends BasePage {
    public ListMusicPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//div[@class='page-header page-header-extra']")
    private WebElement textPopular;
    @FindBy(id = "play4")
    private WebElement btnJpPlay;
    @FindBy(xpath = "//a[@title='Pause']")
    private WebElement btnJpPlayRun;
    @FindBy(xpath = "//a[@id='song-author4']")
    private WebElement btnUser;
    @FindBy(xpath = "//div[@id='song-name4']")
    private WebElement nameMusic;
    @FindBy(xpath = "//div[@id='current-time']")
    private WebElement currentTime;   //div[@id='current-time']
    @FindBy(xpath = "//div/a/div[text()='changthetimdcnhau123']")  // sửa tên bài để check Cancle delete
    ////div[@id='song-name52']
    private WebElement textMusicDelete;
    @FindBy(xpath = "//div[@id='delete-track']")
    private WebElement popupDelete;
    @FindBy(xpath = "//div/a/div[text()='changthetimdcnhau123']/ancestor::div[@class='song-top']/parent::div/child::div[@class='track-actions-container']//div[@class='delete-button']")
    // //div[@id='delete-button-36']
    //div/a/div[text()='Only']/ancestor::div[@class='song-top']/parent::div/child::div[@class='track-actions-container']//div[@class='delete-button']
    private WebElement btnDelete;
    @FindBy(xpath = "//a[normalize-space()='Cancel']")
    private WebElement btnCancel;
    @FindBy(xpath = "//a[@id='delete-button']")
    private WebElement buttonDelete;
    @FindBy(xpath = "//div[@title='2023-10-30T22:20:34+07:00']")
    private WebElement TimeTextDAYAGO;
    @FindBy(xpath = "")
    private WebElement TimeTextMinuteAGO;


    public void popular() throws InterruptedException {
        String ActualTitle = textPopular.getText();
        String ExpectedTitle = "EXPLORE - POPULAR MUSIC";
        Assert.assertEquals(ExpectedTitle, ActualTitle);
        System.out.println(ActualTitle + " Pass");
        sleep(2000);
    }
    public void playMusic() throws InterruptedException {
        btnJpPlay.click();
        sleep(3000);
        btnJpPlayRun.click();
        String ActualText = currentTime.getText();
        String ExpectedText= "00:00";
        Assert.assertNotEquals(ExpectedText, ActualText);
        System.out.println("The song is playing " + ActualText +" second");
    }
    public void Second() throws InterruptedException {
        sleep(1000);
        String ActualTitle = TimeTextDAYAGO.getText();
        String ExpectedTitle = "27 days ago";
        Assert.assertEquals(ExpectedTitle, ActualTitle);
        System.out.println("Time is correct ");
    }
    public void delete() throws InterruptedException {
        btnDelete.click();
        sleep(2000);
        String ActualText = popupDelete.getText();
        String ExpectedText= "Are you sure you want to delete this track?";
        Assert.assertEquals(ExpectedText, ActualText);
        System.out.println("Open pop-up successfully");
        buttonDelete.click();
        System.out.println("--You have successfully deleted your data");
    }
    public void deleteCancel() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)", "");
        btnDelete.click();
        sleep(2000);
        String ActualText = popupDelete.getText();
        String ExpectedText= "Are you sure you want to delete this track?";
        Assert.assertEquals(ExpectedText, ActualText);
        System.out.println("Open pop-up successfully");
        btnCancel.click();
        String ActualMusic = textMusicDelete.getText();
        String ExpectedMusic = "changthetimdcnhau123"; // Sửa tên bài cần KTR khi delete cancle
        Assert.assertEquals(ExpectedMusic, ActualMusic);
        System.out.println("--You have failed to delete data");
    }
}
