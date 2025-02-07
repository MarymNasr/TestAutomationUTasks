package alerts;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ContextMenuTests extends BaseTests {
    @Test
    public void testGetTextAlert(){
        var contextMenu = homePage.clickContextMenuPage();
        contextMenu.rightClickOnBox();
        String text = contextMenu.getAlertText();
        contextMenu.clickOk();
        assertEquals(text, "You selected a context menu","Alert message is incorrect");
    }
}
