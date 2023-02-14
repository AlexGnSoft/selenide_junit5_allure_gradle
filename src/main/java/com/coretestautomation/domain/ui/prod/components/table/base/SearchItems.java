package com.coretestautomation.domain.ui.prod.components.table.base;

import com.codeborne.selenide.SelenideElement;
import com.coretestautomation.domain.ui.prod.components.AbstractComponent;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class SearchItems extends AbstractComponent {

    public final SelenideElement searchBtn = $(By.xpath("//a[@role='button']//span[text()='Search']"));
    public final SelenideElement searchEnterSearchText = $(By.xpath("//div[@role='presentation']//input[@placeholder='Enter search text']"));
    public final SelenideElement searchSelectSearchField = $(By.xpath("//input[@placeholder='Select Search Field']"));
    public final SelenideElement searchStartTypingToFilterGrid = $(By.xpath("//input[@placeholder='Start typing to filter grid']"));
    public final SelenideElement selectSearchFieldBtn = $(By.xpath("//input[@placeholder='Select Search Field']//following::div[contains(@id,'trigger-picker')]"));
    public final SelenideElement noDataToDisplayMessage = $(By.xpath("//div[@role]/div[text()='No data to display']//following::div[text()='No data to display']"));



}
