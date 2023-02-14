package com.coretestautomation.domain.ui.prod.popups;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.coretestautomation.core.logger.Log;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AddNewOfferPopUp extends AbstractPopUp {

    public final SelenideElement addNewOfferPopUpTitle = $(By.xpath("//div[contains(@id,'offeradd')]//div[text()='Add New Offer']"));
    public final SelenideElement selectEmrBtn = $(By.xpath("//div[contains(@id,'channels')]//label[text()='Select EMR']"));
    public final ElementsCollection channelsPickerList = $$(By.xpath("//li[@role='option' and @data-boundview='channels-picker']"));


    @Step("Verify that expected channel exist in channels picker list")
    public boolean isChannelDisplayedInOptionList(String channelName) {
        boolean isDisplayed = false;

        for (SelenideElement selenideElement : channelsPickerList) {
            if (selenideElement.getText().contains(channelName)) {
                isDisplayed = true;
                break;
            }
        }

        Log.info("Is channel " + "'" + channelName + "'" + " displayed in channels picker drop down: " + isDisplayed);

        return isDisplayed;
    }
}
