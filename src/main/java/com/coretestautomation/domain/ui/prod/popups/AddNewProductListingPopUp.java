package com.coretestautomation.domain.ui.prod.popups;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AddNewProductListingPopUp extends AbstractPopUp {

    public final SelenideElement addProductListingPopUpTitle = $(By.xpath("//div[contains(@id,'productlistingadd')]//div[text()='Add New ProductListing']"));
    public final SelenideElement selectProductField = $(By.xpath("//input[@placeholder='Select a Product']"));
    public final SelenideElement searchField = $(By.xpath("//div[contains(@id,'trigger')]//input[@name='productId']"));
    public final SelenideElement searchBtn = $(By.xpath("//div[3][contains(@class,'x-panel')]//span[text()='Search']"));
}
