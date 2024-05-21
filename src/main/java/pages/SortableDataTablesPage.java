package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SortableDataTablesPage {

    private WebDriver driver;
    public SortableDataTablesPage(WebDriver driver){
        this.driver=driver;
    }
    private By tableExample1 = By.id("table1");
    private By rowsTable1 = By.tagName("tr");

    public int getNumberOfRows (){
       return driver.findElement(tableExample1).findElements(rowsTable1).size();
    }
}
