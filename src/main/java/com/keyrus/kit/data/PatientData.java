package com.keyrus.kit.data;

import com.keyrus.kit.models.enums.BloodType;
import com.keyrus.kit.models.enums.Nationality;
import com.keyrus.kit.models.enums.Risk;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientData {

    private Long id;
    private String name;
    private String phoneNumber;
    private BloodType bloodType;
    private Nationality nationality;
    private String doc;
    private Integer age;
    private DnaData dna;

    private Long idPatient;
    private Boolean suspicious;
    private Boolean confirmed;
    private Boolean quarantine;
    private Risk risk;

}
