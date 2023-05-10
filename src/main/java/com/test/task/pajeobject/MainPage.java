package com.test.task.pajeobject;

import static com.codeborne.selenide.Selenide.$;
import static com.test.task.consts.Duration.TWENTY_SECONDS;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class MainPage extends BasePage {

    private static final By SEARCH_BUTTON = By.xpath("//button/span[contains(text(), 'Search')]");
    private SelenideElement getSearchButton() {
        return $(SEARCH_BUTTON);
    }


    @Step("Click on Search button")
    public MainPage clickOnSearchButton() {
        getSearchButton().shouldBe(Condition.visible, TWENTY_SECONDS);
        getSearchButton().click();
        return this;
    }
}
