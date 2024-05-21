package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicLoadingExample1Page {
    private WebDriver driver;
    public DynamicLoadingExample1Page(WebDriver driver){
        this.driver=driver;
    }
    private By startButton= By.cssSelector("#start button");
    private By loadingImage= By.id("loading");
    private By loadedText = By.id("finish");

    public void clickStartButton(){
        driver.findElement(startButton).click();
        //Explicit wait
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.invisibilityOf(
//                driver.findElement(loadingImage)));
        //Fluent wait
        FluentWait wait =new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOf(
                driver.findElement(loadingImage)));
    }
    public String getLoadedText(){
        return driver.findElement(loadedText).getText();
    }

}
