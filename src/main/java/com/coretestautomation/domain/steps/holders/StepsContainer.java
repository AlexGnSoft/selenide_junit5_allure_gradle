package com.coretestautomation.domain.steps.holders;

import com.coretestautomation.domain.steps.implementation.AdminSteps;
import com.coretestautomation.domain.steps.implementation.LoginSteps;
import com.coretestautomation.domain.steps.interfaces.IAdminSteps;
import com.coretestautomation.domain.steps.interfaces.ILoginSteps;

public class StepsContainer {

    public final ILoginSteps loginSteps;
    public final IAdminSteps adminSteps;

    public StepsContainer() {
        adminSteps = new AdminSteps();
        loginSteps = new LoginSteps();
    }


}
