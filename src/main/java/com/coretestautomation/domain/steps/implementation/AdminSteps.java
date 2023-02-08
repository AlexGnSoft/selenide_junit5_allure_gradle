package com.coretestautomation.domain.steps.implementation;

import com.codeborne.selenide.Condition;
import com.coretestautomation.core.logger.Log;
import com.coretestautomation.domain.entities.product.Product;
import com.coretestautomation.domain.steps.holders.PagesContainer;
import com.coretestautomation.domain.steps.holders.PopUpsContainer;
import com.coretestautomation.domain.steps.interfaces.IAdminSteps;
import com.coretestautomation.domain.ui.prod.components.table.base.TableRowItem;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;

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

       page.adminPage.sideBarMenu.openItem("Product Maintenance");
       page.productMaintenancePage.addProductBtn.click();
       popUp.addProductPopUp.shouldBeVisibleHaveText(popUp.addProductPopUp.addProductPopUpTitle, "Add a Product");
       popUp.addProductPopUp.productNameField.setValue(product.getProductName());
       popUp.addProductPopUp.manufacturerField.setValue(product.getManufacturer());
       popUp.addProductPopUp.saveBtn.click();
       popUp.addProductPopUp.productSuccessfullySavedMessage.shouldBe(visible);
       popUp.addProductPopUp.OkStatusBtn.click();

       return this;
    }

    @Step("Update product")
    @Override
    public AdminSteps updateProduct(Product product) {
        Log.info("Updating a product with name: ' " + product.getProductName() + " '");

        page.productMaintenancePage.clickOnVisible(page.productMaintenancePage.editProductIcon);
        popUp.addProductPopUp.productNameField.shouldBe(visible).setValue(product.getProductName());
        popUp.addProductPopUp.saveBtn.click();
        popUp.addProductPopUp.productSuccessfullySavedMessage.shouldBe(visible);
        popUp.addProductPopUp.OkStatusBtn.click();

        return this;
    }

    @Step("Find Product")
    @Override
    public boolean findProduct(Product product) {
        Log.info("Performing search for a product with name: ' " + product.getProductName() + " '");
        page.productMaintenancePage.productMaintenanceTable.searchEnterSearchText(product.getProductName());
        page.productMaintenancePage.productMaintenanceTable.searchSelectSearchField("Product Name");
        page.productMaintenancePage.productMaintenanceTable.clickOnSearchButton();

        return page.productMaintenancePage.productMaintenanceTable.isProductInTheList();
    }

    @Step("Verify That Object Existence In Table")
    @Override
    public boolean verifyObjectExistenceInTable(String productParameter, String byColumnName){
        boolean result = false;

        TableRowItem product_name = page.productMaintenancePage.productMaintenanceTable.searchInTable(byColumnName, productParameter);

        String dataByHeader = product_name.getDataByHeader(byColumnName);
        if(dataByHeader.contains(productParameter))
            result = true;

        Log.info("Is object " + productParameter + "' is found? '"+ result);
        return result;
    }

    @Step("add new product to product listing")
    @Override
    public AdminSteps addNewProductListing(Product product, String drugNDC) {
        if(!page.productListingPage.isOpened(page.productListingPage.addProductListingBtn)){
            page.productMaintenancePage.sideBarMenu.openItem("Product Listing Maintenance");
        }

        page.productListingPage.addProductListingBtn.click();
        popUp.addNewProductListingPopUp.shouldBeVisibleHaveText(popUp.addNewProductListingPopUp.addProductListingPopUpTitle,"Add New ProductListing");
        popUp.addNewProductListingPopUp.selectProductField.click();

        //wait for FE fixes to get locators from disappearing pop up
        popUp.addNewProductListingPopUp.searchField.setValue(product.getProductName());
        popUp.addNewProductListingPopUp.searchBtn.click();

        page.productMaintenancePage.sleepWait(4000);


        return this;
    }



    @Override
    public boolean findProductListing(Product product, String drugNDC) {



        return true;
    }
}
