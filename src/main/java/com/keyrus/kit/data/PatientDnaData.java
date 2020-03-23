package com.keyrus.kit.data;

import com.keyrus.kit.models.Dna;
import com.keyrus.kit.models.Patient;

public class PatientDnaData {

    protected Patient patient;
    protected Dna dna;

    public PatientDnaData() {
    }
    public PatientDnaData(Patient patient, Dna dna) {
        this.patient = patient;
        this.dna = dna;
    }

    @Override
    public String toString() {
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
}
