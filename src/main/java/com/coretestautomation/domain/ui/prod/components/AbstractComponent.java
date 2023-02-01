package com.coretestautomation.domain.ui.prod.components;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

public class AbstractComponent {
    protected WebDriverRunner driver;
    public AbstractComponent() {
        driver = new WebDriverRunner();
    }

    public boolean isVisible(SelenideElement selenideElement){
        return selenideElement.exists();
    }
}
