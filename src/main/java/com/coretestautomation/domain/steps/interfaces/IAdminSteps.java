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
     * Update product
     *
     * @param product                 product as an object
     *
     * @return IAdminSteps object
     */
    AdminSteps updateProduct(Product product);

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

    /**
     * Adding new product listing
     *
     * @param product      product as an object
     * @param drugNDC      National Drug Code for a product
     *
     * @return IAdminSteps object
     */
    AdminSteps addNewProductListing(Product product, String drugNDC);

    /**
     * Find a product listing
     *
     * @param product  product as an object
     * @param drugNDC  National Drug Code for a product
     *
     * @return true if product exist, otherwise false
     */
    boolean findProductListing(Product product, String drugNDC);






}
