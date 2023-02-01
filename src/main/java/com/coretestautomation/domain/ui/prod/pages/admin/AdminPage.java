package com.coretestautomation.domain.ui.prod.pages.admin;

import com.codeborne.selenide.SelenideElement;
import com.coretestautomation.domain.ui.prod.pages.AbstractPage;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class AdminPage extends AbstractPage {

    public final SelenideElement adminSideBarTitle = $(By.xpath("//div[text()='Admin Options']"));

}