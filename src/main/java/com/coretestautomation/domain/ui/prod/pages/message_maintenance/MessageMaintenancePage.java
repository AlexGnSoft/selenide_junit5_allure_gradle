package com.coretestautomation.domain.ui.prod.pages.message_maintenance;

import com.codeborne.selenide.SelenideElement;
import com.coretestautomation.domain.ui.prod.pages.AbstractPage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MessageMaintenancePage extends AbstractPage {

    public final SelenideElement addMessageBtn = $(By.xpath("//a[@role='button']//span[text()='Add Message']"));
}
