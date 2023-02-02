package com.coretestautomation.domain.entities.product;

/**
 * Product represents products for product maintenance module
 */

public class Product {

    private String productName;
    private String manufacturer;

    public Product(String productName, String manufacturer) {
        this.productName = productName;
        this.manufacturer = manufacturer;
    }

    public Product() {

    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
