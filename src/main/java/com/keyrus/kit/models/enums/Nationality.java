package com.keyrus.kit.models.enums;

import com.keyrus.kit.exceptions.NationalityException;

public enum Nationality {

    BRA,
    COM,
    CHN,
    ITA,
    TUN,
    DEU,
    FRA,
    PRT,
    CA,
    AFG;


    public static Nationality getNationality(String type) {
        for (Nationality bt : Nationality.values()) {
            if (bt.equals(type.toUpperCase())) return bt;
        }
        throw new NationalityException("Nationality not found");
    }
}
