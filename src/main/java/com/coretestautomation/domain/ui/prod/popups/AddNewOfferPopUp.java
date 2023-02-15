package com.coretestautomation.domain.ui.prod.popups;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.coretestautomation.core.logger.Log;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AddNewOfferPopUp extends AbstractPopUp {

    public final SelenideElement addNewOfferPopUpTitle = $(By.xpath("//div[contains(@id,'offeradd')]//div[text()='Add New Offer']"));
    public final SelenideElement offerTypeFieldDropDown = $(By.xpath("//div/input[@placeholder='Select Offer Type']"));
    public final SelenideElement availableValuesDropDown = $(By.xpath("//div[@data-ref='listWrap']/ul[contains(@aria-label,'Available values')]"));
    public final SelenideElement offerDescriptionField = $(By.xpath("//input[@placeholder='Offer Description']"));
    public final SelenideElement selectEmrBtn = $(By.xpath("//div[contains(@id,'channels')]//label[text()='Select EMR']"));
    public final ElementsCollection channelsPickerList = $$(By.xpath("//li[@role='option' and @data-boundview='channels-picker']"));


    @Step("Verify that expected channel exist in channels picker list")
    public boolean isChannelDisplayedInOptionList(String channelName) {
        boolean isDisplayed = false;
        channelsPickerList.shouldHave(CollectionCondition.sizeGreaterThan(10));

        for (int i = 0; i < channelsPickerList.size(); i++) {
            if(channelsPickerList.get(i).getText().contains(channelName)){
                isDisplayed = true;
            }
        }

        Log.info("Is channel " + "'" + channelName + "'" + " displayed in channels picker drop down: " + isDisplayed);


        for (int i = 0; i < cancelBtn.size(); i++) {
            cancelBtn.get(1).click();
        }

        return isDisplayed;
    }
}
