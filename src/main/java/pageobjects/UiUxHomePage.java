package pageobjects;

import core.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.lang.Thread.sleep;

public class UiUxHomePage extends BasePage {
    public UiUxHomePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//a[contains(text(),'Connect')]")
    private WebElement btnConnect;
    @FindBy(xpath = "//div[@id='tab-login']")
    private WebElement btnLogin;
    @FindBy(xpath = "//div[@id='tab-register']")
    private WebElement btnRegister;
    @FindBy(id ="search")
    private WebElement searchInput;
    @FindBy(xpath = "//div[@id='song-name5']")
    private WebElement collection_product_links;
    @FindBy(xpath = "//div[contains(text(),'No results available. Try another search.')]")
    private WebElement text_search_fail;
    @FindBy(xpath = "//a[contains(text(),'Join now')]")
    private WebElement btnJoinNow;
    @FindBy(xpath = "//div[contains(text(),'Popular')]")
    private WebElement textPopular;
    @FindBy(id = "song-art5")
    private WebElement hoverPlay;
    @FindBy(css = "#play5")
    private WebElement btnPlay;
    @FindBy(xpath = "//a[@title='Pause']")
    private WebElement btnPlayUp;
    @FindBy(id = "current-time")
    private WebElement currentTime;
    @FindBy(xpath = "//div[@class='wc-button']//a[contains(text(),'Explore')]")
    private WebElement btnExplore;


    public void buttonConnectText(){
        String ActualTitle = btnConnect.getText();
        String ExpectedTitle = "Connect";
        Assert.assertEquals(ExpectedTitle, ActualTitle);
        System.out.println("Text of button connect is correct");
    }
    public void buttonConnectLocation(){
        String ActualTitle = btnConnect.getText();
        String ExpectedTitle = "Connect";
        Assert.assertEquals(ExpectedTitle, ActualTitle);
        System.out.println("Text of button connect is correct");
    }
    public void buttonRegister(){
        btnConnect.getLocation();
        Point btnconnect = btnConnect.getLocation();
    }
    public void search(String search) throws InterruptedException {
        sleep(1000);
        searchInput.sendKeys(search);
        sleep(2000);
        String ActualTitle = collection_product_links.getText();
        String ExpectedTitle = "Hon Ca Yeu - Duc Phuc";
        Assert.assertEquals(ExpectedTitle, ActualTitle);
        System.out.println("Search results : " + ActualTitle);
    }
    public void searchFail(String search) throws InterruptedException {
        sleep(1000);
        searchInput.sendKeys(search);
        sleep(2000);
        String ActualTitle = text_search_fail.getText();
        String ExpectedTitle = "No results available. Try another search.";
        Assert.assertEquals(ExpectedTitle, ActualTitle);
        System.out.println(ActualTitle);
        searchInput.clear();
    }
    public void returnHome() throws InterruptedException {
        sleep(1000);
        driver.navigate().to("http://localhost/music_mp3/index.php");
        System.out.println("Return Home");
    }
    public void hoverJoinNow() throws InterruptedException {
        sleep(1000);
        Actions action = new Actions(driver);
        action.moveToElement(btnJoinNow).build().perform();
        sleep(1000);
        System.out.println("Hover Track is successfull");
    }
    public void buttonJoinNow() throws InterruptedException {
        btnJoinNow.click();
        sleep(2000);
    }
    public void play() throws InterruptedException {
        sleep(1000);
        Actions action = new Actions(driver);
        action.moveToElement(hoverPlay).build().perform();
        btnPlay.click();
        sleep(5000);
        btnPlayUp.click();
        String ActualText = currentTime.getText();
        String ExpectedText= "00:00";
        Assert.assertNotEquals(ExpectedText, ActualText);
        System.out.println("The song is playing " + ActualText +" second");
    }
    public void popular() throws InterruptedException {
        String ActualTitle = textPopular.getText();
        String ExpectedTitle = "POPULAR";
        Assert.assertEquals(ExpectedTitle, ActualTitle);
        System.out.println("Popular position is correct");
        sleep(2000);
    }
    public void explore() throws InterruptedException {
        btnExplore.click();
        driver.navigate().to("http://localhost/music_mp3/index.php?a=explore&filter=popular%20music");
        System.out.println("Explore screen is display");
    }
}
