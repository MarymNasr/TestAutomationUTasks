package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LargeAndDeepDOMPage {
    private WebDriver driver;
    private By table = By.id("large-table");
    public LargeAndDeepDOMPage(WebDriver driver){
        this.driver=driver;
    }
    public void scrollToTable(){
        WebElement tableElement=driver.findElement(table);
        //js has a method called scrollIntoView()
        //table.scrollIntoView() but we will use a placeholder
        String script="arguments[0].scrollIntoView();";
        //to execute js and cast the object
        ((JavascriptExecutor)driver).executeScript(script,tableElement);
    }
}
