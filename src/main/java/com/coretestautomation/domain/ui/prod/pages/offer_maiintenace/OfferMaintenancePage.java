package com.coretestautomation.domain.ui.prod.pages.offer_maiintenace;

import com.codeborne.selenide.SelenideElement;
import com.coretestautomation.domain.ui.prod.pages.AbstractPage;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class OfferMaintenancePage extends AbstractPage {

    public final SelenideElement addOfferBtn = $(By.xpath("//a[@role='button']//span[text()='Add Offer']"));

}
