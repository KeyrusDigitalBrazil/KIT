package com.keyrus.kit.models.enums;

import com.keyrus.kit.exceptions.BloodTypeException;

public enum BloodType {

    A_POSITIVE("A+"),
    A_NEGATIVE("A-"),
    B_POSITIVE("B+"),
    B_NEGATIVE("B-"),
    AB_POSITIVE("AB+"),
    AB_NEGATIVE("AB-"),
    O_POSITIVE("O+"),
    O_NEGATIVE("O-");

    private final String label;

    BloodType(String label) {
        this.label = label;
    }

    public static BloodType getBloodType(String type) {
        for (BloodType bt : BloodType.values()) {
            if (bt.label.equalsIgnoreCase(type)) return bt;
        }
        throw new BloodTypeException("Blood Type not found");
    }

    @Override
    public String toString() {
        return label;
    }

}
