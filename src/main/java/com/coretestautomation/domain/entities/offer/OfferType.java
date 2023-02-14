package com.coretestautomation.domain.entities.offer;

public enum OfferType {

    BRAND_OFFER("Brand offer"),
    CASH_OFFER("Cash offer"),
    ENROLLMENT_OFFER("Enrollment Offer"),
    PATIENT_SUPPORT_PROGRAM("Patient Support Program");

    private String val;

    private OfferType(String val) {
        this.val = val;
    }

    public String getValue() {
        return val;
    }


}
