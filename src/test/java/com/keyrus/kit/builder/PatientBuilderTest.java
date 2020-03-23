package com.keyrus.kit.builder;

import com.keyrus.kit.models.Dna;
import com.keyrus.kit.models.Patient;
import com.keyrus.kit.models.enums.BloodType;
import com.keyrus.kit.models.enums.Nationality;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PatientBuilderTest {
    private static Patient patient;
    private static Set<Patient> patientSet;

    public PatientBuilderTest() {
        patient = new Patient(1L, "José Alves", "+55(11)91234-5678", BloodType.A_NEGATIVE, Nationality.BRA,
                "08172367082", 25, new Dna(1L, "3D8F825"), 1L, Boolean.FALSE, Boolean.FALSE);
    }

    public static Patient defaultValues() {
        new PatientBuilderTest();
        return patient;
    }

    public static Set<Patient> patientBuilderList() {
        patientSet = Stream.of(
                new Patient(1L, "José Alves", "+55(11)91234-5678", BloodType.A_NEGATIVE, Nationality.BRA,
                        "08172367082", 25, new Dna(1L, "3D8F825"), 1L, Boolean.FALSE, Boolean.FALSE),
                new Patient(10L, "Carlitositos Tevezitos", "+57(15)5474-2563", BloodType.A_NEGATIVE, Nationality.COM,
                        "29170060053", 62, new Dna(10L, "7B27BF5"), 10L, Boolean.TRUE, Boolean.FALSE),
                new Patient(11L, "Maria maria", "+86(11)2554-8547", BloodType.O_NEGATIVE, Nationality.CHN,
                        "37069791011", 67, new Dna(11L, "0B8D992"), 11L, Boolean.TRUE, Boolean.TRUE),
                new Patient(12L, "China china", "+86(12)1254-1254", BloodType.B_NEGATIVE, Nationality.CHN,
                        "14792819059", 19, new Dna(12L, "AD77362"), 12L, Boolean.TRUE, Boolean.TRUE)).collect(Collectors.toSet());
        return patientSet;
    }

    public static TreeSet<Patient> patientBuilderListEmpty() {
        return new TreeSet<>();
    }
    @Override
    public String toString() {
        return patient.toString();
    }
}
