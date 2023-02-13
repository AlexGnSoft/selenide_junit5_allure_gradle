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
     * Find a product on Product Maintenance tab
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
    boolean findProductOnProductMaintenance(Product product);

    /**
     * Find a product on Product Listing Maintenance tab
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
    boolean findProductOnListingMaintenance(Product product);


    /**
     * Verify by name that expected product exist in Product Maintenance table
     *
     * Note! Table can contain several products which names starts by the same letter
     * (it's the way search mode is working)
     *
     * @param productParameter  product parameter (Product Name, Manufacturer etc.)
     * @param byColumnName      any name of the column
     *
     * @return true if product exist, otherwise false
     */
    boolean verifyObjectExistenceInProductMaintenanceTable(String productParameter, String byColumnName);

    /**
     * Verify by name that expected product exist in Product Listing Maintenance table
     *
     * Note! Table can contain several products which names starts by the same letter
     * (it's the way search mode is working)
     *
     * @param productName       product name
     * @param byColumnName      any name of the column
     *
     * @return true if product exist, otherwise false
     */
    boolean verifyObjectExistenceInProductListingMaintenanceTable(String productName, String byColumnName);

    /**
     * Verify NDC number
     *
     * @param NDC_Expected      product NDC number
     *
     * @return true if product NDC number equals vs the one entered during adding, otherwise false
     */
    boolean isNdcCorrect(String NDC_Expected);

    /**
     * Verify Strength
     *
     * @param Strength         product Strength
     *
     * @return true if product Strength number equals vs the one entered during adding, otherwise false
     */
    boolean isStrengthCorrect(String Strength);

    /**
     * Adding new product listing
     *
     * @param product           product as an object
     * @param drugNDC           National Drug Code for a product
     * @param drugStrength      drug strength
     *
     * @return IAdminSteps object
     */
    AdminSteps addNewProductListing(Product product, String drugNDC, String drugStrength);

    /**
     * Change product status from active to inactive
     *
     * @return IAdminSteps object
     */
    AdminSteps inactivateProduct(Product product);

    /**
     * Change product status from inactive to active
     *
     * @return IAdminSteps object
     */
    AdminSteps activateProduct(Product product);

    /**
     * Check product status
     *
     * @param product                   product status of which you need to verify
     * @param expectedProductStatus     the expected product status
     *
     * @return true if product is found in the corresponding tabs
     * (of Active or Inactive) on  Product Maintenance page, otherwise false
     */
    boolean checkProductStatus(Product product, String expectedProductStatus);







}
