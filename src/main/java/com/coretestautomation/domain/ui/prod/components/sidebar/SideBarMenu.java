package com.coretestautomation.domain.ui.prod.components.sidebar;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.coretestautomation.core.logger.Log;
import com.coretestautomation.domain.ui.prod.components.AbstractComponent;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SideBarMenu extends AbstractComponent {

    public final SelenideElement sideBarElement = $(By.xpath("//div[contains(@class,'x-panel x-border-item') and contains(@id,'adminlist')]"));
    public final ElementsCollection sideBarItems = $$(By.xpath("//div[@class='x-dataview-item']/div[contains(text(),'')]"));


    public void openItem(String sideBarItemName){

        if(sideBarElement.isDisplayed()){

            for (SelenideElement sideBarItem : sideBarItems) {
                if (sideBarItem.getText().contains(sideBarItemName)) {
                    sideBarItem.click();
                }
            }

            Log.error("Side bar menu is not displayed");
        }
    }
}
