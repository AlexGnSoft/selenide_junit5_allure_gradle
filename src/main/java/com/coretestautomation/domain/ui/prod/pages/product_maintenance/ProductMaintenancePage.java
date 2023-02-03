package com.coretestautomation.domain.ui.prod.pages.product_maintenance;

import com.codeborne.selenide.SelenideElement;
import com.coretestautomation.domain.ui.prod.components.table.base.ItemsTable;
import com.coretestautomation.domain.ui.prod.pages.AbstractPage;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class ProductMaintenancePage extends AbstractPage {

    public ItemsTable productMaintenanceTable;

    public final SelenideElement addProductBtn = $(By.xpath("//a[@role='button']//span[text()='Add Product']"));
    public final SelenideElement activeBtn = $(By.xpath("//a[@role='button']//span[text()='Active']"));
    public final SelenideElement notActiveBtn = $(By.xpath("//a[@role='button']//span[text()='Not Active']"));
    public final SelenideElement allBtn = $(By.xpath("//a[@role='button']//span[text()='All']"));
    public final SelenideElement productMaintenanceTableLocator = $(By.id("productGrid-bodyWrap"));


    public ProductMaintenancePage(){
        productMaintenanceTable = new ItemsTable(productMaintenanceTableLocator);
    }


}
