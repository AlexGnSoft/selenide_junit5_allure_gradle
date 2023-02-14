package com.coretestautomation.domain.ui.prod.pages;

import com.codeborne.selenide.SelenideElement;
import com.coretestautomation.domain.ui.prod.components.sidebar.SideBarMenu;
import com.coretestautomation.domain.ui.prod.components.table.base.SearchItems;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class AbstractPage implements IUtilAbstract {

    public SideBarMenu sideBarMenu;
    public SearchItems searchItems;
    public final SelenideElement activeBtn = $(By.xpath("//a[@role='button']//span[text()='Active']"));
    public final SelenideElement activePressedBtn = $(By.xpath("//a[contains(@class,'small x-btn-pressed')]//span[text()='Active']"));
    public final SelenideElement notActiveBtn = $(By.xpath("//a[@role='button']//span[text()='Not Active']"));
    public final SelenideElement notActivePressedBtn = $(By.xpath("//a[contains(@class,'small x-btn-pressed')]//span[text()='Not Active']"));
    public final SelenideElement allBtn = $(By.xpath("//a[@role='button']//span[text()='All']"));
    public final SelenideElement allPressedBtn = $(By.xpath("//a[contains(@class,'small x-btn-pressed')]//span[text()='All']"));

    public AbstractPage() {
        sideBarMenu = new SideBarMenu();
        searchItems = new SearchItems();
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

    @Override
    public boolean isChecked(SelenideElement webElement) {
        return webElement.isSelected();
    }

    @Override
    public void unCheck(SelenideElement webElement) {
        if(isChecked(webElement))
            webElement.click();
    }
}
