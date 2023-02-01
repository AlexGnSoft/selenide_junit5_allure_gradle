package com.coretestautomation.domain.ui.prod.pages;

import com.codeborne.selenide.SelenideElement;

public interface IUtilAbstract {

    /**
     * Service method to stop driver execution
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


}
