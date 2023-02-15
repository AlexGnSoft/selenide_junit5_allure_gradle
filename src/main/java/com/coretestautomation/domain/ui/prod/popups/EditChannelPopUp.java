package com.coretestautomation.domain.ui.prod.popups;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class EditChannelPopUp extends AbstractPopUp{


    public final ElementsCollection editChannelPopUpTitle = $$(By.xpath("//div[contains(@id,'channeledit')]//div[text()='Edit Channel']"));
    public final SelenideElement selectOfferTypeDropDown = $(By.xpath("//div[@id]/input[contains(@id,'offerTypes')]"));
    public final SelenideElement enterSearchTextOfferTypes = $(By.xpath("//div[@id='offerTypes-picker-innerCt']//input[@placeholder='Enter search text']"));
    public final SelenideElement removeAllOfferTypesBtn = $(By.xpath("//div[contains(@id,'offerTypes')]//span[contains(@id,'button')]/span[text()='Remove All']"));
    public final SelenideElement selectAllOfferTypesBtn = $(By.xpath("//div[contains(@id,'offerTypes')]//span[text()='Select All']"));
    public final SelenideElement offerCheckBox = $(By.xpath("//div[@class='x-grid-cell-inner x-grid-checkcolumn-cell-inner']"));
    public final SelenideElement saveBtn = $(By.xpath("//a[@role='button']//span[@id]/span[text()='Save']"));





}
