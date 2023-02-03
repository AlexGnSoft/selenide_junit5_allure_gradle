package com.coretestautomation.domain.steps.implementation;

import com.codeborne.selenide.Condition;
import com.coretestautomation.domain.entities.product.Product;
import com.coretestautomation.domain.steps.holders.PagesContainer;
import com.coretestautomation.domain.steps.holders.PopUpsContainer;
import com.coretestautomation.domain.steps.interfaces.IAdminSteps;
import io.qameta.allure.Step;

public class AdminSteps implements IAdminSteps {

    private final PagesContainer page;
    private final PopUpsContainer popUp;

    public AdminSteps() {
        page = new PagesContainer();
        popUp = new PopUpsContainer();
    }

    @Step("Add new product")
    @Override
    public AdminSteps addNewProduct(Product product) {
       if (!page.adminPage.isOpened(page.adminPage.adminSideBarTitle)) {
            page.dashboardPage.headerMenu.adminHeaderTab.click();
        }

       page.adminPage.sideBarMenu.openItem("Product Maintenance", 10);
       page.productMaintenancePage.addProductBtn.click();
       popUp.addProductPopUp.shouldBeVisibleHaveText(popUp.addProductPopUp.addProductPopUpTitle, "Add a Product");
       popUp.addProductPopUp.productNameField.setValue(product.getProductName());
       popUp.addProductPopUp.manufacturerField.setValue(product.getManufacturer());
       popUp.addProductPopUp.saveBtn.click();
       popUp.addProductPopUp.productSuccessfullySavedMessage.shouldBe(Condition.visible);
       popUp.addProductPopUp.OkStatusBtn.click();

       return this;
    }

    @Override
    public boolean findProduct(Product product) {
        boolean exist = false;

        page.productMaintenancePage.searchGridDataField.setValue(product.getProductName());
        page.productMaintenancePage.searchSelectSearchField.setValue("Product Name");
        page.productMaintenancePage.searchBtn.click();

        return exist;
    }
}
