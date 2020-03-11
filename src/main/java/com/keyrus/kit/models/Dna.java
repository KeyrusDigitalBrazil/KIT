package com.keyrus.kit.models;

public class Dna {

    private Integer id;
    private String dna;

    public Dna(Integer id, String dna) {
        this.id = id;
        this.dna = dna;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDna() {
        return dna;
    }

    public void setDna(String dna) {
        this.dna = dna;
    }

}
