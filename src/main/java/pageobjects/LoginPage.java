package pageobjects;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static java.lang.Thread.sleep;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//div[@id='tab-login']")
    private WebElement tagLogin;
    @FindBy(xpath = "//div[@id='tab-register']")
    private WebElement tagRegister;
    @FindBy(xpath = "//body/div[@id='connect']/div[1]/div[3]/div[2]/form[1]/div[1]/input[1]")
    private WebElement usernameInput;
    @FindBy(xpath = "//body/div[@id='connect']/div[1]/div[3]/div[2]/form[1]/div[1]/input[2]")
    private WebElement passwordInput;
    @FindBy(id = "login-button")
    private WebElement submitBtn;
    @FindBy(xpath = "//p[contains(text(),'Invalid username or password')]")
    private WebElement invalidText;
    @FindBy(xpath = "//div[contains(text(),'dinhduy')]")
    private WebElement NameAccount;
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public void inputUsername(String username) throws InterruptedException {
        sleep(1000);
        usernameInput.sendKeys(username);
    }
    public void inputPassword(String password) throws InterruptedException {
        sleep(1000);
        passwordInput.sendKeys(password);
    }
    public void clickSubmitBtn() throws InterruptedException {
        sleep(1000);
        submitBtn.click();
    }
    public void testLogin() throws InterruptedException {
        sleep(1000);
        String ActualTitle = invalidText.getText();
        String ExpectedTitle = "Invalid username or password";
        Assert.assertEquals(ExpectedTitle, ActualTitle);
        System.out.println("Login Fail : Invalid username or password ");
        usernameInput.clear();
        passwordInput.clear();
    }
    public void loginPass() throws InterruptedException {
//        driver.navigate().to("http://localhost/music_mp3/index.php?a=stream");
//        System.out.println("Login Pass ");
        sleep(1000);
        String ActualTitle = usernameInput.getText();
        String ExpectedTitle = driver.findElement(By.xpath("//div[contains(text(),'dinhduy20112001')]")).getText();
        Assert.assertEquals(ExpectedTitle, ActualTitle);
        System.out.println("Login Success");
    }
    public void loginHome() throws InterruptedException {
        sleep(1000);
        String ActualTitle = tagLogin.getText();
        String ExpectedTitle = "Login";
        Assert.assertEquals(ExpectedTitle, ActualTitle);
        System.out.println("Redirected to successful login");
        driver.navigate().to("http://localhost/music_mp3/index.php");
    }
}
