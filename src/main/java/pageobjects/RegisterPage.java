package pageobjects;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static java.lang.Thread.sleep;

public class RegisterPage extends BasePage {
    //Find Locator Element
    @FindBy(xpath = "//body/div[@id='connect']/div[1]/div[4]/div[2]/div[1]/form[1]/input[1]")
    private WebElement usernameInput;
    @FindBy(xpath = "//body/div[@id='connect']/div[1]/div[4]/div[2]/div[1]/form[1]/input[2]")
    private WebElement passwordInput;
    @FindBy(xpath = "//body/div[@id='connect']/div[1]/div[4]/div[2]/div[1]/form[1]/input[3]")
    private WebElement emailInput;
    @FindBy(id = "register-button")
    private WebElement registerBtn;
    @FindBy(xpath = "//div[@class='notification-box notification-box-modal notification-box-error']")
    private WebElement Notification;


    public RegisterPage(WebDriver driver) {
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
    public void inputEmail(String email) throws InterruptedException {
        sleep(1000);
        emailInput.sendKeys(email);
    }
    public void clickRegisterBtn() throws InterruptedException {
        sleep(1000);
        registerBtn.click();
    }

    public void testRegister() throws InterruptedException {
        sleep(1000);
        usernameInput.clear();
        passwordInput.clear();
        emailInput.clear();
        sleep(1000);
        String ActualTitle = Notification.getText();
        String ExpectedTitle = "Valid Email , Password , UserName";
        Assert.assertNotEquals(ExpectedTitle, ActualTitle);
        System.out.println("Register Fail : Invalid username or password or email");
    }
    public void registerPass() throws InterruptedException {
        sleep(1000);
        String ActualTitle = usernameInput.getText();
        String ExpectedTitle = driver.findElement(By.xpath("//div[normalize-space()='dinhduy9122']")).getText();
        Assert.assertEquals(ExpectedTitle, ActualTitle);
        System.out.println("Register Success");
    }
}
