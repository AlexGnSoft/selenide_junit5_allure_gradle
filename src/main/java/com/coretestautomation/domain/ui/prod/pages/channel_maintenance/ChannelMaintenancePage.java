package com.coretestautomation.domain.ui.prod.pages.channel_maintenance;

import com.codeborne.selenide.SelenideElement;
import com.coretestautomation.domain.ui.prod.components.table.base.ItemsTable;
import com.coretestautomation.domain.ui.prod.pages.AbstractPage;
import static com.codeborne.selenide.Selenide.$;
import org.openqa.selenium.By;


public class ChannelMaintenancePage extends AbstractPage {

    public ItemsTable channelMaintenanceTable;
    public final SelenideElement channelMaintenanceTableLocator = $(By.id("channelGrid-bodyWrap"));
    public final SelenideElement editChannelIcon = $(By.xpath("//div[@unselectable]/div[normalize-space(@data-qtip)='Edit Channel']"));
    public final SelenideElement singleLineTableElement = $(By.xpath("//div[@id='channelGrid-body']//table"));

    public ChannelMaintenancePage() {
        channelMaintenanceTable = new ItemsTable(channelMaintenanceTableLocator);
    }
}

