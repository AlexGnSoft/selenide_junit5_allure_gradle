package com.coretestautomation.domain.ui.prod.components.header;

import com.codeborne.selenide.SelenideElement;
import com.coretestautomation.core.logger.Log;
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
    public final SelenideElement welcomeEmailDropDown = $(By.xpath("//span[text()='agnuskin@optimizerx.com']"));
    public final SelenideElement logOutBtn = $(By.xpath("//span[text()='Log out']"));


    public boolean isUserLoggedIn(String username) {
        By element = By.xpath(String.format(USERNAME_SPAN, username));
        SelenideElement userNameSpan = $(element);

        try {
            return userNameSpan.getText().contains(username);
        } catch (WebDriverException ex) {
          Log.error("Can not get username", ex);
            return false;
        }
    }
}
