package com.keyrus.kit.convert;

import com.keyrus.kit.data.DnaData;
import com.keyrus.kit.data.PatientData;
import com.keyrus.kit.models.Dna;
import com.keyrus.kit.models.Patient;
import com.keyrus.kit.models.PatientBuilder;
import org.springframework.stereotype.Component;

@Component
public class PatientConvert {

    public PatientData convertModel(Patient patient) {
        PatientData patientData = new PatientData();

        patientData.setId(patient.getId());
        patientData.setName(patient.getName());
        patientData.setPhoneNumber(patient.getPhoneNumber());
        patientData.setBloodType(patient.getBloodType());
        patientData.setNationality(patient.getNationality());
        patientData.setDoc(patient.getDoc());
        patientData.setAge(patient.getAge());
        patientData.setDna(new DnaData(patient.getDna().getId(), patient.getDna().getDna()));
        patientData.setIdPatient(patient.getId());
        patientData.setSuspicious(patient.getSuspicious());
        patientData.setConfirmed(patient.getConfirmed());
        patientData.setQuarantine(patient.getQuarantine());
        patientData.setRisk(patient.getRisk());

        return patientData;
    }

    public Patient convertData(PatientData patientData) {
        return new PatientBuilder()
                .setIdPatient(patientData.getIdPatient())
                .setName(patientData.getName())
                .setPhoneNumber(patientData.getPhoneNumber())
                .setBloodType(patientData.getBloodType())
                .setNationality(patientData.getNationality())
                .setDoc(patientData.getDoc())
                .setAge(patientData.getAge())
                .setDna(new Dna(patientData.getDna().getId(), patientData.getDna().getDna()))
                .setSuspicious(patientData.getSuspicious())
                .setConfirmed(patientData.getConfirmed())
                .setQuarantine(patientData.getQuarantine())
                .setRisk(patientData.getRisk())
                .build();
    }

}
