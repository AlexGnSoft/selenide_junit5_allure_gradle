package com.coretestautomation.domain.steps.interfaces;


import com.coretestautomation.domain.entities.product.Product;
import com.coretestautomation.domain.steps.implementation.AdminSteps;

public interface IAdminSteps extends IBaseSteps{

    /**
     * Adding new product
     *
     * @param product      product as an object
     *
     * @return IAdminSteps object
     */
    AdminSteps addNewProduct(Product product);

    /**
     * Find product
     *
     * @param product  product as an object
     *
     * @return true if product exist, otherwise false
     */
    boolean findProduct(Product product);


}
