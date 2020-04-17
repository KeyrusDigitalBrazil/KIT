package com.keyrus.kit.models;

public class DnaBuilder {

    protected Long id;
    protected String dna;

    public DnaBuilder() {    }

    public DnaBuilder(Long id, String dna) {
        this.id = id;
        this.dna = dna;
    }

    public Long getId() {
        return id;
    }

    public DnaBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDna() {
        return dna;
    }

    public DnaBuilder setDna(String dna) {
        this.dna = dna;
        return this;
    }

    public Dna build() {
        return new Dna(id, dna);
    }

}
