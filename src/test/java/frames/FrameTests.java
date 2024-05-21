package frames;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FrameTests extends BaseTests {
    @Test
    public void testWysiwg(){
        var editorPage= homePage.clickWYSIWYGEditor();
        editorPage.clearTextArea();

        String text1="hello ";
        String text2="world";

        editorPage.setTextArea(text1);
        //editorPage.clickIncreaseIndent();
        editorPage.clearTextArea();
        editorPage.setTextArea(text2);

        assertEquals(editorPage.getTextFromEditor(),text2,"Text from editor is incorrect");
    }
}
