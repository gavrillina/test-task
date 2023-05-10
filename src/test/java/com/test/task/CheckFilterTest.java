package com.test.task;

import static com.test.task.utils.RandomUtils.getRandomButton;
import static com.test.task.utils.RandomUtils.getRandomCheckBox;

import com.test.task.enums.filterpanel.ButtonName;
import com.test.task.enums.filterpanel.CheckBoxName;
import com.test.task.pajeobject.MainPage;
import com.test.task.pajeobject.SearchResultPage;
import com.test.task.pajeobject.element.FilterPanel;
import org.testng.annotations.Test;

public class CheckFilterTest extends BaseTest {

    private static final CheckBoxName checkBoxName= getRandomCheckBox();
    private static final ButtonName buttonName = getRandomButton();

    @Test(testName = "Check filter panel test")
    public void checkFilterTest() {
        new MainPage().clickOnSearchButton();
        new SearchResultPage().openFilterPanel();
        assertion.assertEquals(new SearchResultPage().isFilterPanelDisplayed(), true);
        assertion.assertEquals(new FilterPanel().isApplyButtonEnabled(), true);
        new FilterPanel().selectCheckBoxByName(checkBoxName);
        assertion.assertEquals(new FilterPanel().isCheckBoxSelectedByName(checkBoxName), true);
        new FilterPanel().clickAddButtonByName(buttonName);
        int count = new FilterPanel().getCountOfTypeByButtonName(buttonName);
        assertion.assertEquals(count, 1);
        new FilterPanel().clickClearAllButton();
        count = new FilterPanel().getCountOfTypeByButtonName(buttonName);
        assertion.assertEquals(new FilterPanel().isCheckBoxSelectedByName(checkBoxName), false);
        assertion.assertEquals(count, 0);
        assertion.assertEquals(new FilterPanel().isFromInputFieldEnabled(), true);
        assertion.assertEquals(new FilterPanel().isToInputFieldEnabled(), true);
    }
}
