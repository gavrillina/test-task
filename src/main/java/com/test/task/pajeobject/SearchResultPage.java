package com.test.task.pajeobject;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.test.task.consts.Duration.TEN_SECONDS;
import static com.test.task.consts.Duration.TWENTY_SECONDS;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.test.task.pajeobject.element.FilterPanel;
import io.qameta.allure.Step;
import java.util.List;
import org.openqa.selenium.By;

public class SearchResultPage extends BasePage {

    private static final By SEARCH_ITEM = By.xpath("//a[contains(@href, 'listing')]//ancestor::a//h3");
    private static final By ALL_ITEMS_LABEL = By.xpath("//h2");
    private static final By PAGE_BUTTON_ITEM =
        By.xpath("//div[contains(@style, 'user-select')]//button[@type='button']");
    private static final By FILTER_BUTTON = By.xpath("//button/span[contains(text(), 'Filter')]");

    private SelenideElement getAllItemsLabel() {
        return $(ALL_ITEMS_LABEL);
    }

    private List<SelenideElement> getAllPageButtons() {
        return $$(PAGE_BUTTON_ITEM);
    }
    private int getCountOfAllAvailableListings() {
        int count = getAllSearchItems().size();
        for (int i = 0; i < getAllPageButtons().size() - 3; i++) {
            getAllPageButtons().get(i + 2).click();
            getAllSearchItems().get(0).shouldBe(Condition.visible, TWENTY_SECONDS);
            count += getAllSearchItems().size();
        }
        return count;
    }

    private int getAllListingsOfSearch() {
        String countListingsOfSearch = getAllItemsLabel().text();
        return Integer.parseInt(countListingsOfSearch.substring(0, 2));
    }

    @Step("Is all listings are displayed correctly")
    public boolean isAllListingsLabelDisplayedCorrectNumberOfAvailableListings() {
        return getAllListingsOfSearch() == getCountOfAllAvailableListings();
    }

    private FilterPanel getFilterPanel() {
        return new FilterPanel();
    }

    private List<SelenideElement> getAllSearchItems() {
        return $$(SEARCH_ITEM);
    }

    private SelenideElement getFilterButton() {
        return $(FILTER_BUTTON);
    }

    @Step("Is Filter panel displayed")
    public boolean isFilterPanelDisplayed() {
        return isElementDisplayed(getFilterPanel().getRoot(), 10);
    }

    @Step("Click Filter button")
    public void openFilterPanel() {
        getFilterButton().shouldBe(Condition.visible, TEN_SECONDS);
        getFilterButton().click();
    }
}
