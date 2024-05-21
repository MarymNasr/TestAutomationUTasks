package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuPage {
    WebDriver driver;
    private By contextBox = By.id("hot-spot");
    public ContextMenuPage ( WebDriver driver){
        this.driver=driver;
    }
    public void rightClickOnBox (){
       WebElement box = driver.findElement(contextBox);
        Actions actions = new Actions(driver);
        actions.contextClick(box).perform();
    }
    public String getAlertText(){
        return driver.switchTo().alert().getText();
    }
    public void clickOk(){
        driver.switchTo().alert().accept();
    }

}
