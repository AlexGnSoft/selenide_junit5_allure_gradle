package com.coretestautomation.domain.steps.holders;

import com.coretestautomation.domain.ui.prod.popups.*;

public class PopUpsContainer {

    public final AddProductPopUp addProductPopUp;
    public final AddNewProductListingPopUp addNewProductListingPopUp;
    public final StatusChangePopUp statusChangePopUp;
    public final EditChannelPopUp editChannelPopUp;
    public final AddNewOfferPopUp addNewOfferPopUp;

    public PopUpsContainer(){
        addProductPopUp = new AddProductPopUp();
        addNewProductListingPopUp = new AddNewProductListingPopUp();
        statusChangePopUp = new StatusChangePopUp();
        editChannelPopUp = new EditChannelPopUp();
        addNewOfferPopUp = new AddNewOfferPopUp();
    }
}
