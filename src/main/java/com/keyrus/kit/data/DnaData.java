package com.keyrus.kit.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DnaData implements Comparable<DnaData> {

    private Long id;
    private String dna;

    @Override
    public int compareTo(DnaData o) {
        return (int) (this.id - o.getId());
    }
}
