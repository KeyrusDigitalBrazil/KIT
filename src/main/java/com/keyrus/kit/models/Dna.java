package com.keyrus.kit.models;

import java.lang.reflect.Field;

public class Dna {

    private Long id;
    private String dna;

    public Dna() {
    }

    public Dna(Long id, String dna) {
        this.id = id;
        this.dna = dna;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDna() {
        return dna;
    }

    public void setDna(String dna) {
        this.dna = dna;
    }

    public boolean checkNull() throws IllegalAccessException {
        for (Field f : getClass().getDeclaredFields())
            if (f.get(this) != null)
                return false;
        return true;
    }

    public String toPrint() {
        return "==========================================================================================================================" +
                "\nDna " +
                "\nID: '" + id + "\'" +
                "\nDNA: '" + dna + '\'' +
                "\nPerson: \n"
                ;
    }
}
