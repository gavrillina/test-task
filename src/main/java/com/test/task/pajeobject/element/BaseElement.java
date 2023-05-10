package com.test.task.pajeobject.element;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class BaseElement {

    private final SelenideElement root;

    public BaseElement(By locator) {
        this.root = $(locator);
    }

    public SelenideElement getRoot() {
        return root;
    }
}
