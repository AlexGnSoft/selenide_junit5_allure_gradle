package com.coretestautomation.domain.ui.prod.popups;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.coretestautomation.domain.ui.prod.pages.AbstractPage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AbstractPopUp extends AbstractPage {

    protected WebDriverRunner driverRunner;

    public final SelenideElement OkStatusBtn = $(By.xpath("//div[contains(@id,'messagebox')]//span[text()='OK']"));

    public AbstractPopUp(){
        driverRunner = new WebDriverRunner();
    }




}
