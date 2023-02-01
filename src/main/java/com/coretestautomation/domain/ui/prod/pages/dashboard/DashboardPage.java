package com.coretestautomation.domain.ui.prod.pages.dashboard;

import com.coretestautomation.domain.ui.prod.components.header.HeaderMenu;
import com.coretestautomation.domain.ui.prod.pages.AbstractPage;

public class DashboardPage extends AbstractPage {
    public HeaderMenu headerMenu;

    public DashboardPage(){
        headerMenu = new HeaderMenu();
    }
}
