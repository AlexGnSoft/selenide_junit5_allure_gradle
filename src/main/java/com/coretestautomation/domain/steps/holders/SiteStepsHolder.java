package com.coretestautomation.domain.steps.holders;

import com.coretestautomation.domain.steps.implementation.LoginSteps;
import com.coretestautomation.domain.steps.interfaces.ILoginSteps;

public class SiteStepsHolder {

    public final ILoginSteps loginSteps;

    public SiteStepsHolder() {
        loginSteps = new LoginSteps();
    }


}
