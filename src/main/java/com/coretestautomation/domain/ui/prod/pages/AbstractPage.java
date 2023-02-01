package com.coretestautomation.domain.ui.prod.pages;

import com.codeborne.selenide.SelenideElement;
import com.coretestautomation.domain.ui.prod.components.sidebar.SideBarMenu;

public class AbstractPage implements IUtilAbstract {

    public SideBarMenu sideBarMenu;

    public AbstractPage() {
        sideBarMenu = new SideBarMenu();
    }

    @Override
    public void sleepWait(int waitTime){
        try{
            Thread.sleep(waitTime);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean isOpened(SelenideElement webElement) {
        return webElement.exists();
    }
}
