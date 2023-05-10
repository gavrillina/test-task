package com.test.task;

import com.test.task.pajeobject.MainPage;
import com.test.task.pajeobject.SearchResultPage;
import org.testng.annotations.Test;

public class CheckListingsCountTest extends BaseTest {

    @Test(testName = "Check listings count test")
    public void checkListingsCountTest() {
        new MainPage().clickOnSearchButton();
        assertion.assertEquals(new SearchResultPage().isAllListingsLabelDisplayedCorrectNumberOfAvailableListings(), true);
    }
}
