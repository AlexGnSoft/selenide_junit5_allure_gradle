package com.coretestautomation.domain.steps.holders;

import com.coretestautomation.domain.ui.prod.pages.admin.AdminPage;
import com.coretestautomation.domain.ui.prod.pages.dashboard.DashboardPage;
import com.coretestautomation.domain.ui.prod.pages.login.LoginPage;
import com.coretestautomation.domain.ui.prod.pages.product_maintenance.ProductMaintenancePage;

public class PagesContainer {
    public final LoginPage loginPage;
    public final AdminPage adminPage;
    public final DashboardPage dashboardPage;
    public final ProductMaintenancePage productMaintenancePage;

    public PagesContainer() {
        loginPage = new LoginPage();
        adminPage = new AdminPage();
        dashboardPage = new DashboardPage();
        productMaintenancePage = new ProductMaintenancePage();
    }
}
