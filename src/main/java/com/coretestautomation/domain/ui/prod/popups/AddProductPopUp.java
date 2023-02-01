package com.coretestautomation.domain.ui.prod.popups;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class AddProductPopUp extends AbstractPopUp{

    public final SelenideElement addProductPopUpTitle = $(By.xpath("//div[contains(@id,'productadd')]//div[text()='Add a Product']"));





}
