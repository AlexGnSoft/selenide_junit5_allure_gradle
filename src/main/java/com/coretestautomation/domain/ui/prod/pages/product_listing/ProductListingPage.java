package com.coretestautomation.domain.ui.prod.pages.product_listing;

import com.codeborne.selenide.SelenideElement;
import com.coretestautomation.domain.ui.prod.pages.AbstractPage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ProductListingPage extends AbstractPage {

    public final SelenideElement addProductListingBtn = $(By.xpath("//a[@role='button']//span[text()='Add ProductListing']"));


}
