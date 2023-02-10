package com.coretestautomation.domain.ui.prod.pages.product_maintenance;

import com.codeborne.selenide.SelenideElement;
import com.coretestautomation.domain.ui.prod.components.table.base.ItemsTable;
import com.coretestautomation.domain.ui.prod.pages.AbstractPage;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class ProductMaintenancePage extends AbstractPage {

    public ItemsTable productMaintenanceTable;

    public final SelenideElement addProductBtn = $(By.xpath("//a[@role='button']//span[normalize-space()='Add Product']"));
    public final SelenideElement activeBtn = $(By.xpath("//a[@role='button']//span[normalize-space()='Active']"));
    public final SelenideElement notActiveBtn = $(By.xpath("//a[@role='button']//span[normalize-space()='Not Active']"));
    public final SelenideElement allBtn = $(By.xpath("//a[@role='button']//span[normalize-space()='All']"));
    public final SelenideElement productMaintenanceTableLocator = $(By.id("productGrid-bodyWrap"));
    public final SelenideElement editProductIcon = $(By.xpath("//div[@unselectable]/div[normalize-space(@data-qtip)='Edit Product']"));


    public ProductMaintenancePage(){
        productMaintenanceTable = new ItemsTable(productMaintenanceTableLocator);
    }

}
