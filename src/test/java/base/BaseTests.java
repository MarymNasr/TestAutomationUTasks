package base;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.WindowManager;

import javax.imageio.IIOException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseTests {
    private WebDriver driver;
    //test classes that inherit from the baseTests will have access to homePage
    protected HomePage homePage;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        //driver.manage().timeouts().pageLoadTimeout();
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        goHome();

        homePage = new HomePage(driver);
//        WebElement shiftingContent = driver.findElement(By.linkText("Shifting Content"));
//        shiftingContent.click();
//        //driver.findElement(By.linkText("Shifting Content")).click();
//
//        WebElement menuElement = driver.findElement(By.linkText("Example 1: Menu Element"));
//        menuElement.click();
//        // driver.findElement(By.linkText(("Example 1: Menu Element"))).click();
//
//        List <WebElement> menuItems =driver.findElements(By.tagName("li"));
//        System.out.println("Number of menu items: " + menuItems.size());
    }
    @BeforeMethod
    public void goHome(){
        driver.get("https://the-internet.herokuapp.com/");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @AfterMethod
    public void recordFailure(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus())
        {
            //object to take a screenshot
            //cast the driver
            var camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);

            Path destinationPath = Paths.get("resources/screenshots/" + result.getName() + ".png");
            //System.out.println("Screenshoot taken: "+ screenshot.getAbsolutePath());
            try{
                // Ensure the destination directory exists
                Files.createDirectories(destinationPath.getParent());

                // Move the screenshot file to the destination path
                Files.move(screenshot.toPath(), destinationPath);
                // Files.move(screenshot, new File("resources/screenshots/test.png"));
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }
}
