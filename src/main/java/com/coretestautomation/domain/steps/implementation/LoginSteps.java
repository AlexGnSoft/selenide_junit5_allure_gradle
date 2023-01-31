package com.coretestautomation.domain.steps.implementation;

import com.coretestautomation.core.logger.Logger;
import com.coretestautomation.domain.steps.interfaces.ILoginSteps;
import com.coretestautomation.domain.ui.prod.pages.dashboard.DashboardPage;
import com.coretestautomation.domain.ui.prod.pages.login.LoginPage;

public class LoginSteps implements ILoginSteps {

    public LoginPage loginPage;
    public DashboardPage dashboardPage;

    public LoginSteps() {
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
    }

    @Override
    public LoginSteps loginAs(String userId, String password) {
        loginPage.login.setValue(userId);
        loginPage.password.setValue(password);
        loginPage.signInBtn.click();

        return this;
    }

    @Override
    public boolean isUserLoggedIn(String userId) {
        boolean isLoggedIn = false;

        if(dashboardPage.headerMenu.isUserLoggedIn(userId)){
            Logger.info("User is successfully logged in");
            isLoggedIn = true;
        }else {
            Logger.error("User is not successfully logged in");
        }

        return isLoggedIn;
    }
}
