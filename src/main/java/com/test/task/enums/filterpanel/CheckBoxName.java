package com.test.task.enums.filterpanel;

public enum CheckBoxName {

    AIR_CONDITIONING("Air conditioning"),
    BEACH_FRONT("Beach front"),
    FREE_WIFI("Free WiFi"),
    PETS_ALLOWED("Pets allowed"),
    STREET_PARKING("Street parking"),
    SWIMMING_POOL("Swimming pool"),
    KITCHEN("Kitchen"),
    WASHING_MACHINE("Washing Machine"),
    HOT_TUBE("Hot tub"),
    SUITABLE_FOR_CHILDREN("Suitable for children");

    private final String name;

    CheckBoxName(String s) {
        name = s;
    }

    public String getName() {
        return name;
    }
    }
