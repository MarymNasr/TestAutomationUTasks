package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;
    //private cause it is a field & we r practicing encapsulation
    //private  By formAuthenticationLink = By.linkText("Form Authentication");
    //constructor
    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    //method to interact with the link
    //will find an element passing in this by
    public LoginPage clickFormAuthentication(){
        clickLink("Form Authentication");
        //driver.findElement(formAuthenticationLink).click();
        return new LoginPage(driver);
    }
    public DropdownPage clickDropDown(){
        clickLink("Dropdown");
        return new DropdownPage(driver);
    }

    public HoversPage clickHovers(){
        clickLink("Hovers");
        return new HoversPage(driver);
    }

    public KeyPressesPage clickKeyPresses(){
        clickLink("Key Presses");
        return new KeyPressesPage(driver);
    }
    public HorizontalSliderPage clickHorizontalSlider(){
        clickLink("Horizontal Slider");
        return new HorizontalSliderPage(driver);
    }
    public AlertsPage clickJavaScriptAlerts(){
        clickLink("JavaScript Alerts");
        return new AlertsPage(driver);
    }
    public FileUploadPage clickFileUploadPage(){
        clickLink("File Upload");
        return new FileUploadPage(driver);
    }
    public ContextMenuPage clickContextMenuPage(){
        clickLink("Context Menu");
        return new ContextMenuPage(driver);
    }
    public WYSIWYGEditorPage clickWYSIWYGEditor(){
        clickLink("WYSIWYG Editor");
        return new WYSIWYGEditorPage(driver);
    }
    public DynamicLoadingPage clickDynamicLoading(){
        clickLink("Dynamic Loading");
        return new DynamicLoadingPage(driver);
    }
    public LargeAndDeepDOMPage clickLargeAndDeepDOM(){
        clickLink("Large & Deep DOM");
        return new LargeAndDeepDOMPage(driver);
    }
    public InfiniteScrollPage clickInfiniteScroll(){
        clickLink("Infinite Scroll");
        return new InfiniteScrollPage(driver);
    }
    public MultipleWindowsPage clickMultipleWindows(){
        clickLink("Multiple Windows");
        return new MultipleWindowsPage(driver);
    }
    public SortableDataTablesPage clickSortableDataTables(){
        clickLink("Sortable Data Tables");
        return new SortableDataTablesPage(driver);
    }


    //generic method gonna use for all of our links
    //private so tests won't call it everytime
    private void clickLink(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }

}
