package com.coretestautomation.domain.steps.interfaces;

import com.coretestautomation.domain.steps.implementation.LoginSteps;

public interface ILoginSteps extends IBaseSteps{

    /**
     * Performs login with provided username and password
     *
     * @param userId    username to use
     * @param password  password to for username
     * @return LoginSteps object
     */
    LoginSteps loginAs(String userId, String password);

    /**
     * Performs log out (required for new test class tests to be started from the scratch
     *
     * @return LoginSteps object
     */
    LoginSteps loginOut();

    /**
     * Returns true if user is logged in.
     *
     * @return true if user is logged in.
     */
    boolean isUserLoggedIn(String  userId);
}
