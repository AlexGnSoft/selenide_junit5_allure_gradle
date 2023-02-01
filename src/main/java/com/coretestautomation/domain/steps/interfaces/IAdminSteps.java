package com.coretestautomation.domain.steps.interfaces;


import com.coretestautomation.domain.steps.implementation.AdminSteps;

public interface IAdminSteps extends IBaseSteps{

    /**
     * Adding new product
     *
//     * @param userId    username to use
//     * @param password  password to for username
     * @return LoginSteps object
     */
    AdminSteps addNewProduct();
}
