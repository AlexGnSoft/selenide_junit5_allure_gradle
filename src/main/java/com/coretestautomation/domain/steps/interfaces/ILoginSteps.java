package com.coretestautomation.domain.steps.interfaces;

import com.coretestautomation.domain.steps.implementation.LoginSteps;

public interface ILoginSteps extends IBaseSteps{

    /**
     * Performs login with provided username and password
     *
     * @param user username to use
     * @param pass password to for username
     * @return LoginSteps object
     */
    LoginSteps loginAs(String user, String pass);

    /**
     * Returns true if user is logged in.
     *
     * @return true if user is logged in.
     */
    boolean isUserLoggedIn();
}
