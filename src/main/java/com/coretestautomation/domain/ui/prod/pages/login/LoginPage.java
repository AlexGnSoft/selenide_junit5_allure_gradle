package com.coretestautomation.domain.ui.prod.pages.login;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.coretestautomation.domain.ui.prod.pages.AbstractPage;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class LoginPage extends AbstractPage {

    public static final SelenideElement login = $("");
    public static final SelenideElement password = $("");
    public static final SelenideElement signInBtn = $("");
    public static final SelenideElement homePage = $("");
    public static final ElementsCollection example = $$("");

}
