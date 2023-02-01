package com.coretestautomation.domain.ui.prod.components.header;

import com.codeborne.selenide.SelenideElement;
import com.coretestautomation.core.logger.Logger;
import com.coretestautomation.domain.ui.prod.components.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import static com.codeborne.selenide.Selenide.$;

public class HeaderMenu extends AbstractComponent {
    private static final String USERNAME_SPAN = "//span[contains(text(), '%s')]";

    public final SelenideElement reportsHeaderTab = $(By.xpath("//span[text()='Reports']"));
    public final SelenideElement adminHeaderTab = $(By.xpath("//span[text()='Admin']"));
    public final SelenideElement userProfileHeaderTab = $(By.xpath("//span[text()='User Profile']"));
    public final SelenideElement programProfileHeaderTab = $(By.xpath("//span[text()='Program Profile']"));
    public final SelenideElement qaToolHeaderTab = $(By.xpath("//span[text()='QA Tool']"));


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
