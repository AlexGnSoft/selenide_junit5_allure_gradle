package com.coretestautomation.domain.steps.implementation;

import com.coretestautomation.core.logger.Logger;
import com.coretestautomation.domain.steps.holders.PagesContainer;
import com.coretestautomation.domain.steps.interfaces.ILoginSteps;

public class LoginSteps implements ILoginSteps {

    public PagesContainer page;


    public LoginSteps() {
        page = new PagesContainer();
    }

    @Override
    public LoginSteps loginAs(String userId, String password) {
        page.loginPage.login.setValue(userId);
        page.loginPage.password.setValue(password);
        page.loginPage.signInBtn.click();

        return this;
    }

    @Override
    public boolean isUserLoggedIn(String userId) {
        boolean isLoggedIn = false;

        if(page.dashboardPage.headerMenu.isUserLoggedIn(userId)){
            Logger.info("User is successfully logged in");
            isLoggedIn = true;
        }else {
            Logger.error("User is not successfully logged in");
        }

        return isLoggedIn;
    }
}
