package com.coretestautomation.domain.steps.containers;

import com.coretestautomation.domain.ui.prod.popups.*;

public class PopUpsContainer {

    public final AddProductPopUp addProductPopUp;
    public final AbstractPopUp abstractPopUp;
    public final AddNewProductListingPopUp addNewProductListingPopUp;
    public final StatusChangePopUp statusChangePopUp;
    public final EditChannelPopUp editChannelPopUp;
    public final AddNewOfferPopUp addNewOfferPopUp;
    public final AddNewMessagePopUp addNewMessagePopUp;

    public PopUpsContainer(){
        abstractPopUp = new AbstractPopUp();
        addProductPopUp = new AddProductPopUp();
        addNewProductListingPopUp = new AddNewProductListingPopUp();
        statusChangePopUp = new StatusChangePopUp();
        editChannelPopUp = new EditChannelPopUp();
        addNewOfferPopUp = new AddNewOfferPopUp();
        addNewMessagePopUp = new AddNewMessagePopUp();
    }
}
