package com.coretestautomation.domain.ui.prod.popups;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AddNewProductListingPopUp extends AbstractPopUp {

    public final SelenideElement addProductListingPopUpTitle = $(By.xpath("//div[contains(@id,'productlistingadd')]//div[text()='Add New ProductListing']"));
    public final SelenideElement selectProductField = $(By.xpath("//input[@placeholder='Select a Product']"));
    public final SelenideElement searchField = $(By.xpath("//div[@role='presentation']/input[@name='searchField']"));
    public final ElementsCollection searchBtns = $$(By.xpath("//span[@id]/span[contains(@id,'btnInnerEl') and contains(text(),'Search')]"));
    public final SelenideElement checkbox = $(By.xpath("//div[@class='x-grid-cell-inner x-grid-checkcolumn-cell-inner']"));
    public final SelenideElement strengthField = $(By.xpath("//div[@id]/input[@name='strength']"));
    public final SelenideElement nDCField = $(By.xpath("//div[@id]/input[@name='productNDC']"));
    public final SelenideElement rxNormNotEmptyStateField = $(By.xpath("//input[@name='rxnorm' and contains(@class,'x-form-field x-form-text x-form-text-default')]"));
    public final SelenideElement saveBtn = $(By.xpath("//a[@role='button']//span[text()='Save']"));
    public final SelenideElement statusOkBtn = $(By.xpath("//a[@role='button']//span[text()='OK']"));


    public void clickOnSearchBtnInsideAddProductListingPopUp(){
        for (int i = 0; i < searchBtns.size(); i++) {
            searchBtns.get(1).click();
        }
    }

}
