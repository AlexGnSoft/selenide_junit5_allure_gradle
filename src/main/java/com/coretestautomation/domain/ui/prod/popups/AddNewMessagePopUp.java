package com.coretestautomation.domain.ui.prod.popups;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AddNewMessagePopUp extends AbstractPopUp{

    public final SelenideElement addNewMessagePopUpTitle = $(By.xpath("//div[contains(@id,'messageadd')]//div[text()='Add New Message']"));
    public final SelenideElement selectChannelDropDown = $(By.xpath("//div[contains(@id,'tagfield')]//input[@name='channels']"));
    public final SelenideElement nameField = $(By.xpath("//input[@placeholder='Name']"));

    public final ElementsCollection channelsPickerList = $$(By.xpath("//li[@role='option' and contains(@data-boundview,'tagfield')]"));
}
