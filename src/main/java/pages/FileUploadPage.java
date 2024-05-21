package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage {
    WebDriver driver;
    public FileUploadPage(WebDriver driver){
        this.driver=driver;
    }
    private By chooseFileButton= By.id("file-upload");
    private By uploadButton= By.id("file-submit");
    private By uploadFiles= By.id("uploaded-files");

    public void clickUploadButton(){
        driver.findElement(uploadButton).click();
    }
    public void uploadFile(String absolutePathOfFile){
        driver.findElement(chooseFileButton).sendKeys(absolutePathOfFile);
        clickUploadButton();
    }
    public String getUploadedFiles(){
        return driver.findElement(uploadFiles).getText();
    }
}
