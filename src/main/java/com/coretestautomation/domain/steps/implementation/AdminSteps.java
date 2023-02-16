package com.coretestautomation.domain.steps.implementation;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.coretestautomation.core.logger.Log;
import com.coretestautomation.domain.entities.offer.OfferType;
import com.coretestautomation.domain.entities.product.Product;
import com.coretestautomation.domain.steps.holders.PagesContainer;
import com.coretestautomation.domain.steps.holders.PopUpsContainer;
import com.coretestautomation.domain.steps.interfaces.IAdminSteps;
import com.coretestautomation.domain.ui.prod.components.table.base.TableRowItem;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;


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

    @Step("Find Product on Product Maintenance tab")
    @Override
    public boolean findProductOnProductMaintenance(Product product) {
        Log.info("Performing search for a product with name: ' " + product.getProductName() + " '");
        page.productMaintenancePage.productMaintenanceTable.searchEnterSearchText(product.getProductName());
        page.productMaintenancePage.productMaintenanceTable.searchSelectSearchField("Product Name");
        page.productMaintenancePage.productMaintenanceTable.clickOnSearchButton();

        return page.productMaintenancePage.productMaintenanceTable.isProductInTheList();
    }

    @Step("Find Product on Product Listing Maintenance tab")
    @Override
    public boolean findProductOnListingMaintenance(Product product) {
        Log.info("Performing search for a product with name: ' " + product.getProductName() + " '");
        page.productListingPage.productListingMaintenanceTable.searchEnterSearchText(product.getProductName());
        page.productListingPage.productListingMaintenanceTable.searchSelectSearchField("Product Name");
        page.productListingPage.productListingMaintenanceTable.clickOnSearchButton();

        return page.productListingPage.productListingMaintenanceTable.isProductInTheList();
    }

    @Step("Verify That Object Existence In Table")
    @Override
    public boolean verifyObjectExistenceInProductMaintenanceTable(String productParameter, String byColumnName) {
        boolean result = false;

        TableRowItem product_name = page.productMaintenancePage.productMaintenanceTable.searchInTable(byColumnName, productParameter);

        String dataByHeader = product_name.getDataByHeader(byColumnName);
        if (dataByHeader.contains(productParameter))
            result = true;

        Log.info("Is object " + productParameter + "' is found? '" + result);
        return result;
    }

    @Step("Verify That Product Name was Added To Product Listing Table")
    @Override
    public boolean verifyObjectExistenceInProductListingMaintenanceTable(String productName, String byColumnName) {
        boolean result = false;

        TableRowItem product_name = page.productListingPage.productListingMaintenanceTable.searchInTable(byColumnName, productName);

        String dataByHeader = product_name.getDataByHeader(byColumnName);
        if (dataByHeader.contains(productName))
            result = true;

        Log.info("Is product with " + productName + "' is found? '" + result);

        return result;
    }

    @Step("Verify that NDC number is valid")
    @Override
    public boolean isNdcCorrect(String NDC_Expected) {
        By NDC_Element = By.xpath(String.format(page.productListingPage.TABLE_VALUE_XPATH, NDC_Expected));
        SelenideElement NDC_Actual = $(NDC_Element);

        try {
            return NDC_Actual.getText().equals(NDC_Expected);
        } catch (WebDriverException ex) {
            Log.error("Can not get NDC number", ex);
            return false;
        }
    }

    @Step("Verify that drug strength data is valid")
    @Override
    public boolean isStrengthCorrect(String Strength_Expected) {
        By Strength_Element = By.xpath(String.format(page.productListingPage.TABLE_VALUE_XPATH, Strength_Expected));
        SelenideElement Strength_Actual = $(Strength_Element);

        try {
            return Strength_Actual.getText().equals(Strength_Expected);
        } catch (WebDriverException ex) {
            Log.error("Can not get Strength value", ex);
            return false;
        }
    }

    @Step("Add new product to product listing")
    @Override
    public AdminSteps addNewProductListing(Product product, String drugStrength, String drugNDC) {
        if (!page.productListingPage.isOpened(page.productListingPage.addProductListingBtn)) {
            page.productMaintenancePage.sideBarMenu.openItem("Product Listing Maintenance");
        }

        page.productListingPage.addProductListingBtn.click();
        popUp.addNewProductListingPopUp.shouldBeVisibleHaveText(popUp.addNewProductListingPopUp.addProductListingPopUpTitle, "Add New ProductListing");
        popUp.addNewProductListingPopUp.selectProductField.click();
        popUp.addNewProductListingPopUp.searchField.shouldBe(visible);
        popUp.addNewProductListingPopUp.searchField.click();
        popUp.addNewProductListingPopUp.searchField.setValue(product.getProductName());
        popUp.addNewProductListingPopUp.clickOnSearchBtnInsideAddProductListingPopUp();
        popUp.addNewProductListingPopUp.checkbox.shouldBe(visible);
        popUp.addNewProductListingPopUp.clickOnVisible(popUp.addNewProductListingPopUp.checkbox);
        popUp.addNewProductListingPopUp.selectProductField.click();
        popUp.addNewProductListingPopUp.strengthField.setValue(drugStrength);
        popUp.addNewProductListingPopUp.nDCField.setValue(drugNDC);
        popUp.addNewProductListingPopUp.rxNormNotEmptyStateField.shouldBe(visible);
        popUp.addNewProductListingPopUp.saveBtn.click();
        popUp.addNewProductListingPopUp.statusOkBtn.click();

        return this;
    }

    @Step("Click on activate product icon to inactivate a product")
    @Override
    public AdminSteps inactivateProduct(Product product) {
        if (!page.productMaintenancePage.activePressedBtn.isDisplayed()) {
            page.productMaintenancePage.activeBtn.click();
        }

        findProductOnProductMaintenance(product);

        page.productMaintenancePage.activateProductIcon.click();
        popUp.statusChangePopUp
                .shouldBeVisibleHaveText
                        (popUp.statusChangePopUp.inActivateMessage,
                                "Are you sure you want to inactivate the product?");
        popUp.statusChangePopUp.yesBtn.click();

        return this;
    }

    @Step("Click on inactivate product icon to activate a product")
    @Override
    public AdminSteps activateProduct(Product product) {
        if (!page.productMaintenancePage.notActivePressedBtn.isDisplayed()) {
            page.productMaintenancePage.notActiveBtn.click();
        }

        findProductOnProductMaintenance(product);

        page.productMaintenancePage.inActivateProductIcon.click();
        popUp.statusChangePopUp
                .shouldBeVisibleHaveText
                        (popUp.statusChangePopUp.activateMessage,
                                "Are you sure you want to activate the product?");
        popUp.statusChangePopUp.yesBtn.click();

        return this;
    }

    @Step("Check product status")
    @Override
    public boolean checkProductStatus(Product product, String expectedProductStatus) {
        switch (expectedProductStatus) {
            case "Not Active":
                if (!page.productMaintenancePage.notActivePressedBtn.isDisplayed()) {
                    page.productMaintenancePage.notActiveBtn.click();
                }

                boolean isProductInNotActiveState = findProductOnProductMaintenance(product);

                if (isProductInNotActiveState) {
                    Log.info("Product status is 'Not Active' as Expected!");
                } else {
                    Log.error("Product was not found in 'Not Active' product list");
                }

                return isProductInNotActiveState;

            case "Active":
                if (!page.productMaintenancePage.activePressedBtn.isDisplayed()) {
                    page.productMaintenancePage.activeBtn.click();
                }

                boolean isProductInActiveState = findProductOnProductMaintenance(product);

                if (isProductInActiveState) {
                    Log.info("Product status is 'Active' as Expected!");
                } else {
                    Log.error("Product was not found in 'Active' product list");
                }

                return isProductInActiveState;

            default:
                Log.error("Product state of unknown");
                return false;
        }
    }

    @Step("Edit channel and select offers")
    @Override
    public AdminSteps editChannel(String channelName, OfferType offerType) {
        if (!page.adminPage.isOpened(page.adminPage.adminSideBarTitle)) {
            page.dashboardPage.headerMenu.adminHeaderTab.click();
        }

        page.adminPage.sideBarMenu.openItem("Channel Maintenance");
        page.channelMaintenancePage.activePressedBtn.shouldBe(visible);
        page.channelMaintenancePage.searchItems.searchStartTypingToFilterGrid.setValue(channelName);
        page.channelMaintenancePage.singleLineTableElement.shouldBe(visible);
        page.channelMaintenancePage.editChannelIcon.click();
        popUp.editChannelPopUp.selectOfferTypeDropDown.click();
        popUp.editChannelPopUp.selectAllOfferTypesBtn.shouldBe(visible).click();
        popUp.editChannelPopUp.removeAllOfferTypesBtn.click();
        popUp.editChannelPopUp.enterSearchTextOfferTypes.click();
        popUp.editChannelPopUp.enterSearchTextOfferTypes.setValue(offerType.getValue());
        popUp.editChannelPopUp.offerCheckBox.shouldBe(visible).click();
        popUp.editChannelPopUp.saveBtn.click();
        popUp.editChannelPopUp.OkStatusBtn.click();

        return this;
    }

    @Step("Verify that channel is displayed in on Offer Level, channel 'Active In' drop-down")
    @Override
    public boolean verifyChannelActiveInDropDown(String channelName, OfferType offerType) {
        if (!page.adminPage.isOpened(page.offerMaintenancePage.addOfferBtn)) {
            page.dashboardPage.sideBarMenu.openItem("Offer Maintenance");
        }

        page.offerMaintenancePage.addOfferBtn.click();
        popUp.addNewOfferPopUp.addNewOfferPopUpTitle.shouldBe(visible);
        popUp.addNewOfferPopUp.offerTypeFieldDropDown.click();
        popUp.addNewOfferPopUp.offerTypeFieldDropDown.setValue(offerType.getValue()).pressEnter();
        popUp.addNewOfferPopUp.offerDescriptionField.click();
        popUp.addNewOfferPopUp.selectEmrBtn.doubleClick();

        return popUp.addNewOfferPopUp.isChannelDisplayedInOptionList(channelName);
    }
}
