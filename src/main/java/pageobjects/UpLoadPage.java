package pageobjects;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import static java.lang.Thread.sleep;

public class UpLoadPage extends BasePage {
    public UpLoadPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//input[@id='track-title']")
    public WebElement InputTitle;
    @FindBy(xpath = "//textarea[@name='description']")
    public WebElement InputDescription;
    @FindBy(xpath = "//input[@placeholder='separated by comma, including genres']")
    public WebElement InputTags;
    @FindBy(xpath = "//div[@class='upload-button']")
    private WebElement buttonUpLoad;
    @FindBy(xpath = "//div[@id='upload-art-btn']")
    private WebElement btnUpLoadImage;
    @FindBy(xpath = "//div[@id='upload-track-btn']")
    private WebElement btnUpLoadTrack;
    @FindBy(xpath = "//input[@id='upload-button']")
    private WebElement btnUpLoadSubmit;
    @FindBy(xpath = "//p[contains(text(),'Your track')]")
    private WebElement NotiTextSuccess;
    @FindBy(xpath = "//p[contains(text(),'The selected cover art is too big. Allowed maxium ')]") //div[@class='notification-box notification-box-success']
    private WebElement NotiText;
    @FindBy(xpath = "//p[normalize-space()='You need to add at least 1 tag']")
    private WebElement TagText;
    @FindBy(xpath = "//p[normalize-space()='The name of a tag should be less than 26 characters']")
    private WebElement TagLength;
    @FindBy(xpath = "//p[normalize-space()='The track title cannot be empty']")
    private WebElement TittleText;
    @FindBy(xpath = "//p[normalize-space()='The track title should be less than 100 characters']")
    private WebElement TittleLength;
    @FindBy(xpath = "//input[@id='track-title']")
    private WebElement TittleTrack;

    String filePathImage = "C:\\Users\\NITRO 5\\Desktop\\ĐỒ ÁN TỐT NGHIỆP\\Ảnh\\ảnh 7.jpg";
    String filePathImageInvalid = "C:\\Users\\NITRO 5\\Desktop\\ĐỒ ÁN TỐT NGHIỆP\\Ảnh\\ErrorIMG.jpg";
    String filePathTrack = "C:\\Users\\NITRO 5\\Desktop\\ĐỒ ÁN TỐT NGHIỆP\\Nhạc\\Giữ em đi.mp3";
    String filePathTrackInvalid = "C:\\Users\\NITRO 5\\Desktop\\ĐỒ ÁN TỐT NGHIỆP\\Nhạc\\ErrorTrack.mp3";
    public void inputTitle(String title) throws InterruptedException {
        InputTitle.sendKeys(title);
        InputTitle.getText();
        sleep(1000);
    }
    public void inputDescription(String description) throws InterruptedException {
        InputDescription.sendKeys(description);
        sleep(1000);
    }
    public void inputTags(String tags) throws InterruptedException{
        InputTags.sendKeys(tags);
        sleep(1000);
    }
    public void ClickbtnUploadSubmid() throws InterruptedException {
        sleep(1000);
        btnUpLoadSubmit.click();
        sleep(1000);
    }
    public void buttonUpLoad() throws InterruptedException {
        sleep(1000);
        buttonUpLoad.click();
    }
    public void UploadImageValid() throws InterruptedException {
//        buttonUpLoad.click();
//        Thread.sleep(1000);
        btnUpLoadImage.click();
        Thread.sleep(1000);
        // Khởi tạo Robot class
        Robot rb = null;
        try {
            rb = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        // Copy File path vào Clipboard
        StringSelection str = new StringSelection(filePathImage);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
        Thread.sleep(1000);
        // Nhấn Control+V để dán
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);
        // Xác nhận Control V trên
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);
        Thread.sleep(1000);
        // Nhấn Enter
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);

        Thread.sleep(1000);
    }
    public void UploadTrackValid() throws InterruptedException {
//        buttonUpLoad.click();
//        Thread.sleep(1000);
        btnUpLoadTrack.click();
        Thread.sleep(1000);
        // Khởi tạo Robot class
        Robot rb = null;
        try {
            rb = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        // Copy File path vào Clipboard
        StringSelection str = new StringSelection(filePathTrack);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
        Thread.sleep(1000);
        // Nhấn Control+V để dán
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);
        // Xác nhận Control V trên
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);
        Thread.sleep(1000);
        // Nhấn Enter
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(1000);
    }
    public void UploadImageInvalid() throws InterruptedException {
        buttonUpLoad.click();
        Thread.sleep(1000);
        btnUpLoadImage.click();
        Thread.sleep(1000);
        // Khởi tạo Robot class
        Robot rb = null;
        try {
            rb = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        // Copy File path vào Clipboard
        StringSelection str = new StringSelection(filePathImageInvalid);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
        Thread.sleep(1000);
        // Nhấn Control+V để dán
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);
        // Xác nhận Control V trên
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);
        Thread.sleep(1000);
        // Nhấn Enter
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);

       // Thread.sleep(4000);
    }
    public void UploadTrackInvalid() throws InterruptedException {
        btnUpLoadTrack.click();
        Thread.sleep(1000);
        // Khởi tạo Robot class
        Robot rb = null;
        try {
            rb = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        // Copy File path vào Clipboard
        StringSelection str = new StringSelection(filePathTrack);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
        Thread.sleep(1000);
        // Nhấn Control+V để dán
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);
        // Xác nhận Control V trên
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);
        Thread.sleep(1000);
        // Nhấn Enter
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
       // Thread.sleep(4000);
    }
    public void InvalidIMG() throws InterruptedException {
        sleep(1000);
        String ActualTitle = NotiText.getText();
        String ExpectedTitle = "The selected cover art is too big. Allowed maxium file size is 2 MB";
        Assert.assertEquals(ExpectedTitle, ActualTitle);
        System.out.println("Upload Fail :  The selected cover art is too big. Allowed maxium file size is 2 MB ");
    }
    public void InvalidTrack() throws InterruptedException {
        sleep(1000);
        String ActualTitle = InputTitle.getText();
        String ExpectedTitle = "";
        String ActualTitle1 = InputTags.getText();
        String ExpectedTitle1 = "";
        Assert.assertEquals(ExpectedTitle, ActualTitle);
        Assert.assertEquals(ExpectedTitle1, ActualTitle1);
        System.out.println("Upload Fail :  Error track ");
    }
    public void Tags() throws InterruptedException {
        sleep(1000);
        String ActualTitle = TagText.getText();
        String ExpectedTitle = "You need to add at least 1 tag";
        Assert.assertEquals(ExpectedTitle, ActualTitle);
        System.out.println("Upload Fail :You need to add at least 1 tag ");
    }
    public void TagsLength() throws InterruptedException {
        sleep(1000);
        String ActualTitle = TagText.getText();
        String ExpectedTitle = "The name of a tag should be less than 26 characters";
        Assert.assertEquals(ExpectedTitle, ActualTitle);
        System.out.println("Upload Fail :The name of a tag should be less than 26 characters ");
    }
    public void Title () throws InterruptedException {
        sleep(1000);
        String ActualTitle = TittleText.getText();
        String ExpectedTitle = "The track title cannot be empty";
        Assert.assertEquals(ExpectedTitle, ActualTitle);
        System.out.println("Upload Fail :The track title cannot be empty ");
    }
    public void TitleLength () throws InterruptedException {
        sleep(1000);
        String ActualTitle = TittleLength.getText();
        String ExpectedTitle = "The track title should be less than 100 characters";
        Assert.assertEquals(ExpectedTitle, ActualTitle);
        System.out.println("Upload Fail :The track title should be less than 100 characters ");
    }
    public void UploadSuccess() throws InterruptedException {
        String ValueTitleTrack = InputTitle.getAttribute("value");
        String ActualText = NotiTextSuccess.getText();
        System.out.println("Song name upload success is " + ValueTitleTrack);
        System.out.println(ActualText  );
        String ExpectedText = "Your track"+" " + ValueTitleTrack + " " +"has been uploaded";
        Assert.assertEquals(ExpectedText, ActualText);
        sleep(3000);
    }
}
