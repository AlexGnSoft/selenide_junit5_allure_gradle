package com.coretestautomation.domain.ui.prod.popups;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class StatusChangePopUp extends AbstractPopUp{

    public final SelenideElement yesBtn = $(By.xpath("//a[@role='button']//span[text()='Yes']"));
    public final SelenideElement noBtn = $(By.xpath("//a[@role='button']//span[text()='No']"));
    public final SelenideElement inActivateMessage = $(By.xpath("//div[contains(@id,'messagebox')]//div[text()='Are you sure you want to inactivate the product?']"));
    public final SelenideElement activateMessage = $(By.xpath("//div[contains(@id,'messagebox')]//div[text()='Are you sure you want to activate the product?']"));
}
