package com.coretestautomation.domain.ui.prod.pages;

import com.codeborne.selenide.SelenideElement;

public interface IUtilAbstract {

    /**
     * Service method to stop driver execution. Should be used in test development purposes.
     *
     * @param milliSeconds   number of millisecond webDriver stops its execution
     */

    void sleepWait(int milliSeconds);


    /**
     * Method is used to verify that webElement is opened and visible of expected page
     *
     * @param webElement   number of millisecond webDriver stops its execution
     */
    boolean isOpened(SelenideElement webElement);


    /**
     * Method is used to verify that webElement is visible and has a certain text
     *
     * @param selenideElement   web element of a page
     * @param shouldHaveText    expected text an element should have
     */

    void shouldBeVisibleHaveText(SelenideElement selenideElement, String shouldHaveText);

    /**
     * Method is used to return text from visible element
     *
     * @param selenideElement   web element of a page
     */
    public String getTextFromVisibleElement(SelenideElement selenideElement);

    /**
     * Method is used to click on visible element
     *
     * @param selenideElement   web element of a page
     */

    void clickOnVisible(SelenideElement selenideElement);

    /**
     * Method is used to verify that checkBox is checked
     *
     * @param webElement  checkBox
     */
    boolean isChecked(SelenideElement webElement);

    /**
     * Method is used to uncheck checked element (checkbox)
     *
     * @param webElement  checkBox
     */
    void unCheck(SelenideElement webElement);


}
