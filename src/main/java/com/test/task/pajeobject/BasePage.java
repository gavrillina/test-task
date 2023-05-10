package com.test.task.pajeobject;

import static com.codeborne.selenide.Condition.visible;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import com.codeborne.selenide.ex.ElementShould;
import com.codeborne.selenide.ex.ElementShouldNot;
import io.qameta.allure.testng.AllureTestNg;
import java.time.Duration;
import org.testng.annotations.Listeners;

@Listeners(AllureTestNg.class)
public class BasePage {

    public static boolean isElementDisplayed(SelenideElement element, int seconds) {
        try {
            element.shouldBe(visible, Duration.ofSeconds(seconds));
            return true;
        }
        catch (ElementNotFound | ElementShouldNot | ElementShould e) {
            return false;
        }
    }
}
