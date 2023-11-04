package pageobjects;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.File;

import static java.lang.Thread.sleep;

public class FilePage extends BasePage {
    public FilePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "div[id='content'] div:nth-child(9)")
    private WebElement textDataEmpty;
    @FindBy(xpath = "//input[@id='upload-button']")
    private WebElement btnUpLoadSubmit;
    @FindBy(xpath = "//div[@class='upload-button']")
    private WebElement btnUpLoad;
//    @FindBy(xpath = "")
//    private WebElement btn;

    public void getData() throws InterruptedException {
        sleep(1000);
        String filePath = "C:\\Users\\NITRO 5\\Desktop\\ĐỒ ÁN TỐT NGHIỆP\\Nhạc\\Giữ em đi.mp3";
        String filePath2 = "C:\\Users\\NITRO 5\\Desktop\\ĐỒ ÁN TỐT NGHIỆP\\Ảnh\\ảnh 7.jpg";
        // Create a File object with the path
        File file = new File(filePath);
        File file1 = new File(filePath2);
        float fileSizeInMB = 0;
        float fileSizeInMB1= 0;
        if (file.exists()) {
            long fileSizeInBytes = file.length(); // Get the size of the file in bytes
            float fileSizeInKB = fileSizeInBytes / 1024 ; // Convert bytes to KB
            fileSizeInMB = fileSizeInKB / 1024 ; // Convert KB to MB
//            System.out.println("File Size in Bytes: " + fileSizeInBytes);
//            System.out.printf("File Size in KB: %.2f\n", fileSizeInKB);
//            System.out.printf("File Size in MB: %.2f\n", fileSizeInMB);;
        } else {
            System.out.println("File does not exist or the path is incorrect.");
        }
        if (file1.exists()) {
            long fileSizeInBytes1 = file1.length(); // Get the size of the file in bytes
            float fileSizeInKB1 = fileSizeInBytes1 / 1024 ; // Convert bytes to KB
            fileSizeInMB1 = fileSizeInKB1 / 1024 ; // Convert KB to MB
//            System.out.println("File Size in Bytes: " + fileSizeInBytes1);
//            System.out.printf("File Size in KB: %.2f\n", fileSizeInKB1);
//            System.out.printf("File Size in MB: %.2f\n", fileSizeInMB1);;
        } else {
            System.out.println("File does not exist or the path is incorrect.");
        }
        String ActualTitle = textDataEmpty.getText();
        String act = ActualTitle.replace("MB", "");
        act = act.trim();
        Double dAct = Double.parseDouble(act);
        Double dAct2 = 0.02;
        double x = dAct + (fileSizeInMB + fileSizeInMB1) - dAct2 ;
        String x2 = String.format("%.02f", x);
        String ExpectedTitle = x2 + " MB" ;
        btnUpLoadSubmit.click();
        sleep(2000);
        driver. navigate(). back();
        sleep(2000);
        btnUpLoad.click();
        sleep(2000);
        String ActualTitle2 = textDataEmpty.getText();
        System.out.println(ActualTitle2);
        Assert.assertEquals(ExpectedTitle, ActualTitle2);
        System.out.println("Upload data successfully");
}

}
