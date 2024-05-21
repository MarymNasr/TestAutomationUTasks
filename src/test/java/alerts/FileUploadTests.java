package alerts;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FileUploadTests extends BaseTests {
    @Test
    public void testFileUpload(){
        var uploadPage= homePage.clickFileUploadPage();
        uploadPage.uploadFile("/Applications/TestAutomationUTasks/pom.xml");
        assertEquals(uploadPage.getUploadedFiles(),"pom.xml","Upload failed");
    }
}
