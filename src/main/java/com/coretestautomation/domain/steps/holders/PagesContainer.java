package com.coretestautomation.domain.steps.holders;

import com.coretestautomation.domain.ui.prod.pages.admin.AdminPage;
import com.coretestautomation.domain.ui.prod.pages.channel_maintenance.ChannelMaintenancePage;
import com.coretestautomation.domain.ui.prod.pages.dashboard.DashboardPage;
import com.coretestautomation.domain.ui.prod.pages.login.LoginPage;
import com.coretestautomation.domain.ui.prod.pages.offer_maiintenace.OfferMaintenancePage;
import com.coretestautomation.domain.ui.prod.pages.product_listing.ProductListingPage;
import com.coretestautomation.domain.ui.prod.pages.product_maintenance.ProductMaintenancePage;
import com.coretestautomation.domain.ui.prod.popups.EditChannelPopUp;

public class PagesContainer {
    public final LoginPage loginPage;
    public final AdminPage adminPage;
    public final DashboardPage dashboardPage;
    public final ProductMaintenancePage productMaintenancePage;
    public final ProductListingPage productListingPage;
    public final ChannelMaintenancePage channelMaintenancePage;
    public final EditChannelPopUp editChannelPopUp;
    public final OfferMaintenancePage offerMaintenancePage;

    public PagesContainer() {
        loginPage = new LoginPage();
        adminPage = new AdminPage();
        dashboardPage = new DashboardPage();
        productMaintenancePage = new ProductMaintenancePage();
        productListingPage = new ProductListingPage();
        channelMaintenancePage = new ChannelMaintenancePage();
        editChannelPopUp = new EditChannelPopUp();
        offerMaintenancePage = new OfferMaintenancePage();
    }
}
