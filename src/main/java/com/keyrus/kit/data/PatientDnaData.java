package com.keyrus.kit.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDnaData implements Comparable<PatientDnaData> {

    private PatientData patient;
    private DnaData dna;

    public boolean checkNull() throws IllegalAccessException {
        for (Field f : getClass().getDeclaredFields())
            if (f.get(this) != null)
                return false;
        return true;
    }

    public String toPrint() {
        return "==========================================================================================================================" +
                "\n Dna " +
                "\n ID: " + dna.getId() +
                "\n DNA: " + dna.getDna() +
                "\n Patient " +
                "\n ID: " + patient.getId() +
                "\n Name: " + patient.getName() +
                "\n DNA: " + patient.getDna().getDna() +
                "\n Blood Type: " + patient.getBloodType() +
                "\n Nationality: " + patient.getNationality() +
                "\n Age: " + patient.getAge() +
                "\n Particle 781N0: " + patient.getSuspicious() +
                "\n Particle 781NC: " + patient.getConfirmed() +
                "\n Risk: " + patient.getRisk() +
                "\n Quarantine: " + patient.getQuarantine() +
                "\n==========================================================================================================================\n";
    }

    @Override
    public int compareTo(PatientDnaData o) {
        return (int) (this.patient.getId() - o.patient.getId());
    }
}
