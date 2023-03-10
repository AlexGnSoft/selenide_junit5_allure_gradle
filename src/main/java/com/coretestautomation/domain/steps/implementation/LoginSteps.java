package com.coretestautomation.domain.steps.implementation;

import com.coretestautomation.core.logger.Log;
import com.coretestautomation.domain.steps.containers.PagesContainer;
import com.coretestautomation.domain.steps.interfaces.ILoginSteps;
import static com.codeborne.selenide.Condition.visible;

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
    public LoginSteps loginOut() {
        page.dashboardPage.headerMenu.welcomeEmailDropDown.shouldBe().click();
        page.dashboardPage.headerMenu.logOutBtn.shouldBe(visible).click();

        return this;
    }

    @Override
    public boolean isUserLoggedIn(String userId) {
        boolean isLoggedIn = false;

        if(page.dashboardPage.headerMenu.isUserLoggedIn(userId)){
            Log.info("User is successfully logged in");
            isLoggedIn = true;
        }else {
          Log.error("User is not successfully logged in");
        }

        return isLoggedIn;
    }
}
