package com.coretestautomation.domain.ui.prod.components.header;

import com.codeborne.selenide.SelenideElement;
import com.coretestautomation.core.logger.Logger;
import com.coretestautomation.domain.ui.prod.components.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;

import static com.codeborne.selenide.Selenide.$;

public class HeaderMenu extends AbstractComponent {
    private static final String USERNAME_SPAN = "//span[contains(text(), '%s')]";

    public boolean isUserLoggedIn(String username) {
        By element = By.xpath(String.format(USERNAME_SPAN, username));
        SelenideElement userNameSpan = $(element);

        try {
            return userNameSpan.getText().contains(username);
        } catch (WebDriverException ex) {
            Logger.error("Can not get username", ex);
            return false;
        }
    }


}
