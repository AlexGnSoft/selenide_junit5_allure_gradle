package com.coretestautomation.domain.ui.prod.popups;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class EditChannelPopUp extends AbstractPopUp{

    public final ElementsCollection editChannelPopUpTitle = $$(By.xpath("//div[contains(@id,'channeledit')]//div[text()='Edit Channel']"));
    public final SelenideElement selectOfferTypeDropDown = $(By.xpath("//div[@id]/input[contains(@id,'offerTypes')]"));
    public final SelenideElement removeAllOfferTypesBtn = $(By.xpath("//div[contains(@id,'offerTypes')]//span[text()='Remove All']"));
    public final SelenideElement selectAllOfferTypesBtn = $(By.xpath("//div[contains(@id,'offerTypes')]//span[text()='Select All']"));
    public final SelenideElement branchOfferCheckBox = $(By.xpath("//tr[@role='row']//td[@role='gridcell']/div[text()='Brand offer']"));
    public final SelenideElement cashOfferCheckBox = $(By.xpath("//tr[@role='row']//td[@role='gridcell']/div[text()='Cash offer']"));
    public final SelenideElement enrollmentOfferCheckBox = $(By.xpath("//td[@role='gridcell']/div[text()='Enrollment Offer']"));
    public final SelenideElement patientSupportProgramCheckBox = $(By.xpath("//td[@role='gridcell']/div[text()='Patient Support Program']"));
    public final SelenideElement saveBtn = $(By.xpath("//a[@role='button']//span[@id]/span[text()='Save']"));



}
