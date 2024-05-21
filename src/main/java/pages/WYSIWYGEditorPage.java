package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WYSIWYGEditorPage {
    WebDriver driver;
    private String editorIframeID= "mce_0_ifr";
    private By textArea = By.id("tinymce");
    private By increaseIndentButton= By.xpath("(//div[@title=\"indentation\"]/button)[2]");

    //By.cssSelector(".tox-toolbar__primary>:nth-child(5)>:nth-child(2)");
    public WYSIWYGEditorPage (WebDriver driver){
        this.driver=driver;
    }
    //you must exit out of the iframe
    public void clearTextArea(){
        switchToEditArea();
        driver.findElement(textArea).clear();
//        try {
//            Thread.sleep(4500);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        switchToMainArea();
    }
    public void setTextArea(String text){
        switchToEditArea();
        driver.findElement(textArea).sendKeys(text);
        switchToMainArea();
    }
    public void clickIncreaseIndent(){
        driver.findElement(increaseIndentButton).click();
    }
    public String getTextFromEditor(){
        switchToEditArea();
        String text =driver.findElement(textArea).getText();
        switchToMainArea();
        return text;
    }

    private void switchToEditArea(){
        driver.switchTo().frame(editorIframeID);
    }
    private void switchToMainArea() {
        driver.switchTo().parentFrame();
    }
}
