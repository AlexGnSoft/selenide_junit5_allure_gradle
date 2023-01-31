package com.coretestautomation.domain.ui.prod.pages.login;

import com.codeborne.selenide.SelenideElement;
import com.coretestautomation.domain.ui.prod.pages.AbstractPage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends AbstractPage {

    public final SelenideElement login = $(By.xpath("//input[@name='userId']"));
    public final SelenideElement password = $(By.xpath("//input[@name='pass']"));
    public final SelenideElement signInBtn = $(By.xpath("//span/div[text()='Sign In']"));

}
