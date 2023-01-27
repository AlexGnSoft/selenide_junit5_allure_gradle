package com.coretestautomation.domain.steps.holders;

import com.coretestautomation.core.helper.IStepsReporter;
import com.coretestautomation.domain.steps.interfaces.IAdminToolsSteps;
import com.coretestautomation.domain.steps.interfaces.ILoginSteps;

public class SiteStepsHolder {

    private ILoginSteps loginSteps;
    private IAdminToolsSteps adminToolsSteps;

    private final IStepsReporter reporter;


    public SiteStepsHolder(IStepsReporter reporter) {
        this.reporter = reporter;
    }

    public ILoginSteps loginSteps() {
        return loginSteps;
    }

    public IAdminToolsSteps adminToolsSteps() {
        return adminToolsSteps;
    }
}
