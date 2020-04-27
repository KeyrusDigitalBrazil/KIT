package com.keyrus.kit.convert;

import com.keyrus.kit.data.DnaData;
import com.keyrus.kit.models.Dna;
import org.springframework.stereotype.Component;

@Component
public class DnaConvert {

    public DnaData convertModel(Dna dna) {
        DnaData dnaData = new DnaData();

        dnaData.setId(dna.getId());
        dnaData.setDna(dna.getDna());

        return dnaData;
    }

    public Dna convertData(DnaData dnaData) {
        Dna dna = new Dna();

        dna.setId(dnaData.getId());
        dna.setDna(dnaData.getDna());

        return dna;
    }

}
