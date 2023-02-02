package com.coretestautomation.domain.ui.prod.pages.product_maintenance;

import com.codeborne.selenide.SelenideElement;
import com.coretestautomation.domain.ui.prod.pages.AbstractPage;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class ProductMaintenancePage extends AbstractPage {
    public final SelenideElement addProductBtn = $(By.xpath("//a[@role='button']//span[text()='Add Product']"));
    public final SelenideElement activeBtn = $(By.xpath("//a[@role='button']//span[text()='Active']"));
    public final SelenideElement notActiveBtn = $(By.xpath("//a[@role='button']//span[text()='Not Active']"));
    public final SelenideElement allBtn = $(By.xpath("//a[@role='button']//span[text()='All']"));
    public final SelenideElement searchBtn = $(By.xpath("//a[@role='button']//span[text()='Search']"));
    public final SelenideElement searchGridDataField = $(By.xpath("//div[@role='presentation']//input[@placeholder='Enter search text']"));
    public final SelenideElement searchSelectSearchField = $(By.xpath("//input[@placeholder='Select Search Field']"));
    public final SelenideElement selectSearchFieldBtn = $(By.xpath("//input[@placeholder='Select Search Field']//following::div[contains(@id,'trigger-picker')]"));

}
