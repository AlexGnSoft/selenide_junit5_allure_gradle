package com.coretestautomation.domain.entities.message;

public enum MessageType {

    CLICKABLE_BANNER_MESSAGE("Click-able Banner Message"),
    DYNAMIC_BANNER_MESSAGE("Dynamic Banner Message"),
    STATIC_BANNER_MESSAGE("Static Text Message");

    private String val;

    private MessageType(String val) {
        this.val = val;
    }

    public String getValue() {
        return val;
    }
}
