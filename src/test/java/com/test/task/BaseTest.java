package com.test.task;

import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.Assertion;

public abstract class BaseTest {

    private static final String BASE_URL = "https://kamil-demo.alpinizm.uz/";
    protected Assertion assertion = new Assertion();

    static {
        Configuration.baseUrl = BASE_URL;
        Configuration.pageLoadTimeout = 20000;
    }

    @BeforeMethod
    public void openSite() {
        open(StringUtils.EMPTY);
    }

    @AfterMethod(alwaysRun = true)
    public void closeDriver() {
        if (WebDriverRunner.hasWebDriverStarted()) {
            WebDriverRunner.closeWebDriver();
        }
    }
}
