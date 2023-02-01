package com.coretestautomation.domain.steps.holders;

import com.coretestautomation.domain.ui.prod.popups.AddProductPopUp;

public class PopUpsContainer {

    public final AddProductPopUp addProductPopUp;

    public PopUpsContainer(){
        addProductPopUp = new AddProductPopUp();
    }
}
