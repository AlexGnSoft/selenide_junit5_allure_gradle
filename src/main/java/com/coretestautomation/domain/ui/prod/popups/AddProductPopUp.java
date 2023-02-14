package com.coretestautomation.domain.ui.prod.popups;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class AddProductPopUp extends AbstractPopUp {

    public final SelenideElement addProductPopUpTitle = $(By.xpath("//div[contains(@id,'productadd')]//div[text()='Add a Product']"));
    public final SelenideElement productNameField = $(By.xpath("//div[contains(@id,'textfield')]//input[@name='name']"));
    public final SelenideElement manufacturerField = $(By.xpath("//div[contains(@id,'combo')]//input[@name='manufacturers']"));
    public final SelenideElement saveBtn = $(By.xpath("//span[contains(@id,'btnWrap')]//span[text()='Save']"));
    public final SelenideElement productSuccessfullySavedMessage = $(By.xpath("//div[text()='Product data successfully saved']"));


}
