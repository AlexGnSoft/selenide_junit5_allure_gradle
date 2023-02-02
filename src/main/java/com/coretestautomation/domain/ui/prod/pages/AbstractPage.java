package com.coretestautomation.domain.ui.prod.pages;

import com.codeborne.selenide.SelenideElement;
import com.coretestautomation.domain.ui.prod.components.sidebar.SideBarMenu;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.sleep;

public class AbstractPage implements IUtilAbstract {

    public SideBarMenu sideBarMenu;

    public AbstractPage() {
        sideBarMenu = new SideBarMenu();
    }

    @Override
    public void sleepWait(int waitTime){
        sleep(waitTime);
    }

    @Override
    public boolean isOpened(SelenideElement webElement) {
        return webElement.exists();
    }

    @Override
    public void shouldBeVisibleHaveText(SelenideElement selenideElement, String shouldHaveText){
        selenideElement.should(be(visible), have(text(shouldHaveText)));
    }

    @Override
    public String getTextFromVisibleElement(SelenideElement selenideElement){
        return selenideElement.shouldBe(visible).getText();
    }

    @Override
    public void clickOnVisible(SelenideElement selenideElement) {
        selenideElement.shouldBe(visible).click();
    }
}
