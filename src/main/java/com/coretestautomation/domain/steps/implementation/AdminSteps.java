package com.coretestautomation.domain.steps.implementation;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.coretestautomation.domain.steps.holders.PagesContainer;
import com.coretestautomation.domain.steps.holders.PopUpsContainer;
import com.coretestautomation.domain.steps.holders.StepsContainer;
import com.coretestautomation.domain.steps.interfaces.IAdminSteps;
import com.coretestautomation.domain.ui.prod.popups.AddProductPopUp;
import io.qameta.allure.Step;

import java.awt.image.BufferedImage;

public class AdminSteps implements IAdminSteps {

    private final PagesContainer page;
    private final PopUpsContainer popUp;

    public AdminSteps() {
        page = new PagesContainer();
        popUp = new PopUpsContainer();
    }

    @Step("Add new product")
    @Override
    public AdminSteps addNewProduct() {
       if (!page.adminPage.isOpened(page.adminPage.adminSideBarTitle)) {
            page.dashboardPage.headerMenu.adminHeaderTab.click();
        }

       page.adminPage.sideBarMenu.openItem("Product Maintenance");
       page.productMaintenancePage.addProductBtn.shouldBe(Condition.interactable).click();
       popUp.addProductPopUp.addProductPopUpTitle.shouldBe(Condition.visible);


        return this;
    }
}
