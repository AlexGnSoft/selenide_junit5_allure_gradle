package com.coretestautomation.domain.steps.holders;

import com.coretestautomation.domain.ui.prod.popups.AddNewProductListingPopUp;
import com.coretestautomation.domain.ui.prod.popups.AddProductPopUp;
import com.coretestautomation.domain.ui.prod.popups.StatusChangePopUp;

public class PopUpsContainer {

    public final AddProductPopUp addProductPopUp;
    public final AddNewProductListingPopUp addNewProductListingPopUp;
    public final StatusChangePopUp statusChangePopUp;

    public PopUpsContainer(){
        addProductPopUp = new AddProductPopUp();
        addNewProductListingPopUp = new AddNewProductListingPopUp();
        statusChangePopUp = new StatusChangePopUp();
    }
}
