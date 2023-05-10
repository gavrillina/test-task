package com.test.task.enums.filterpanel;

public enum ButtonName {

    BEDS("Beds"),
    BEDROOMS("Bedrooms"),
    BATHROOMS("Bathrooms");

    private final String name;

    public String getName() {
        return name;
    }

    ButtonName(String name) {
        this.name = name;
    }
}
