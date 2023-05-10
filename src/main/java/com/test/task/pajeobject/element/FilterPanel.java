package com.test.task.pajeobject.element;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.test.task.consts.Duration.TEN_SECONDS;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.test.task.enums.filterpanel.ButtonName;
import com.test.task.enums.filterpanel.CheckBoxName;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class FilterPanel extends BaseElement {

    private static final By FILTER_PANEL_ROOT =
        By.xpath("//p[contains(text(), 'To filter by price, please select dates')]");
    private static final By FROM_INPUT = By.xpath("//input[@placeholder='From']");
    private static final By TO_INPUT = By.xpath("//input[@placeholder='To']");
    private static final By CLEAR_BUTTON = By.xpath("//b[contains(text(), 'Clear all')]");
    private static final String CHECK_BOX_PATH =
        "//input[@type='checkbox']//ancestor::label//span[contains(text(), '%s')]";
    private static final By APPLY_BUTTON = By.xpath("//button/span[contains(text(), 'Apply')]");
    private static final String ADD_BUTTON = "//div[contains(text(), '%s')]/ancestor::div[1]//button[2]";
    private static final String DELETE_BUTTON = "//div[contains(text(), '%s')]/ancestor::div[1]//button[1]";
    private static final String COUNT = "//div[contains(text(), '%s')]/ancestor::div[1]//span";

    public FilterPanel() {
        super(FILTER_PANEL_ROOT);
    }

    private SelenideElement getInputFromField() {
        return $(FROM_INPUT);
    }

    private SelenideElement getInputToField() {
        return $(TO_INPUT);
    }

    private SelenideElement getClearAllButton() {
        return $(CLEAR_BUTTON);
    }

    private SelenideElement getApplyButton() {
        return $(APPLY_BUTTON);
    }

    private SelenideElement getCheckBoxByName(CheckBoxName name) {
        return $x(String.format(CHECK_BOX_PATH, name.getName()));
    }

    private SelenideElement getAddButtonByName(ButtonName name) {
        return $x(String.format(ADD_BUTTON, name.getName()));
    }

    private SelenideElement getDeleteButtonByName(ButtonName name) {
        return $x(String.format(DELETE_BUTTON, name.getName()));
    }

    private SelenideElement getCountByButtonName(ButtonName name) {
        return $x(String.format(COUNT, name.getName()));
    }

    @Step("Click add button by name {name}")
    public FilterPanel clickAddButtonByName(ButtonName name) {
        getAddButtonByName(name).click();
        return this;
    }

    @Step("Click delete button by name {name}")
    public FilterPanel clickDeleteButtonByName(ButtonName name) {
        getDeleteButtonByName(name).click();
        return this;
    }

    @Step("Get count of {type} by name")
    public int getCountOfTypeByButtonName(ButtonName name) {
        return Integer.parseInt(getCountByButtonName(name).text());
    }

    @Step("Select check box by name")
    public FilterPanel selectCheckBoxByName(CheckBoxName name) {
        getCheckBoxByName(name).shouldBe(Condition.visible, TEN_SECONDS);
        getCheckBoxByName(name).click();
        return this;
    }

    @Step("Is check box {check box name} selected")
    public boolean isCheckBoxSelectedByName(CheckBoxName name) {
        return getCheckBoxByName(name).$x(".//ancestor::label/input[@id='id']").is(Condition.checked);
    }

    @Step("Is from input field enabled")
    public boolean isFromInputFieldEnabled() {
        return getInputFromField().isEnabled();
    }

    @Step("Is to input field enabled")
    public boolean isToInputFieldEnabled() {
        return getInputToField().isEnabled();
    }

    @Step("Click Clear all button")
    public FilterPanel clickClearAllButton() {
        getClearAllButton().shouldBe(Condition.visible, TEN_SECONDS);
        getClearAllButton().click();
        return this;
    }

    @Step("Is Apply button enabled")
    public boolean isApplyButtonEnabled() {
        return getApplyButton().isEnabled();
    }
}
