package com.coretestautomation.domain.ui.prod.pages.product_listing;

import com.codeborne.selenide.SelenideElement;
import com.coretestautomation.domain.ui.prod.components.table.base.ItemsTable;
import com.coretestautomation.domain.ui.prod.pages.AbstractPage;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class ProductListingPage extends AbstractPage {

    public ItemsTable productListingMaintenanceTable;

    public final SelenideElement addProductListingBtn = $(By.xpath("//a[@role='button']//span[text()='Add ProductListing']"));
    public final SelenideElement productListingMaintenanceTableLocator = $(By.id("productlistingGrid"));
    public final String TABLE_VALUE_XPATH = "//td[@role='gridcell']/div[text()='%s']";
    public ProductListingPage() {
        productListingMaintenanceTable = new ItemsTable(productListingMaintenanceTableLocator);
    }
}
