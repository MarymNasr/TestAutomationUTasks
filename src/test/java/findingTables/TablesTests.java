package findingTables;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.HomePage;

import static org.testng.Assert.assertEquals;

public class TablesTests extends BaseTests {

    @Test
            public void testSortableDataTablesPage(){
        var sortableDataTablesPage = homePage.clickSortableDataTables();
        var numberOfRows =sortableDataTablesPage.getNumberOfRows();

        assertEquals(numberOfRows, 5, "wrong number of rows");
    }


}
