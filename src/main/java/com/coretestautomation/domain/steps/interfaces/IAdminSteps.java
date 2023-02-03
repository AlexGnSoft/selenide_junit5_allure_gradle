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
     * Find a product
     *
     *      * Note! Table can contain several products which names starts by the same letters
     *      * (it's the way search mode is working).
     *      * To validate parameters of a certain product from the table use additional method:
     *      * 'verifyProductExistenceInTable')
     *
     * @param product  product as an object
     *
     * @return true if product exist, otherwise false
     */
    boolean findProduct(Product product);


    /**
     * Verify by name that expected product exist in the table
     *
     * Note! Table can contain several products which names starts by the same letter
     * (it's the way search mode is working)
     *
     * @param productParameter  product parameter (Product Name, Manufacturer etc.)
     * @param byColumnName      any name of the column
     *
     * @return true if product exist, otherwise false
     */
    boolean verifyObjectExistenceInTable(String productParameter, String byColumnName);






}
