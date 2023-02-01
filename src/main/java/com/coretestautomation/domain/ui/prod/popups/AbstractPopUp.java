package com.coretestautomation.domain.ui.prod.popups;

import com.codeborne.selenide.WebDriverRunner;
import com.coretestautomation.domain.ui.prod.pages.AbstractPage;

public class AbstractPopUp extends AbstractPage {

    protected WebDriverRunner driverRunner;

    public AbstractPopUp(){
        driverRunner = new WebDriverRunner();
    }




}
