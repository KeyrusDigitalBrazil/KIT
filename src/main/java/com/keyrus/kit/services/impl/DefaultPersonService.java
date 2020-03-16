package com.keyrus.kit.services.impl;

import com.keyrus.kit.models.Dna;
import com.keyrus.kit.models.Patient;
import com.keyrus.kit.models.enums.BloodType;
import com.keyrus.kit.models.enums.Nationality;
import com.keyrus.kit.models.enums.Risk;
import com.keyrus.kit.services.PersonService;

import java.util.Arrays;
import java.util.List;

public class DefaultPersonService implements PersonService {

    @Override
    public List<Patient> generatorPatient() {
        List<Patient> patients = Arrays.asList(

                // Generate List for Brazil
                new Patient(1L, "José Alves", "+55(11)91234-5678", BloodType.A_NEGATIVE, Nationality.BRA,
                        "08172367082", 25, new Dna(1L, "3D8F825"), 1L, Boolean.FALSE, Boolean.FALSE),
                new Patient(2L, "Haythem Chutador de Anão", "+55(13)94325-8547", BloodType.AB_POSITIVE, Nationality.BRA,
                        "52872071075", 34, new Dna(2L, "AC0C4F6"), 2L, Boolean.FALSE, Boolean.FALSE),
                new Patient(3L, "Mariana Clara", "+55(15)98574-2369", BloodType.B_POSITIVE, Nationality.BRA,
                        "159.0263049", 54, new Dna(3L, "5B2B137"), 3L, Boolean.TRUE, Boolean.FALSE),
                new Patient(4L, "Clara Mariana", "+55(21)95841-2100", BloodType.AB_POSITIVE, Nationality.BRA,
                        "80052954056", 15, new Dna(4L, "60C975F"), 4L, Boolean.TRUE, Boolean.FALSE),
                new Patient(5L, "Cachu", "+55(12)94325-8547", BloodType.B_NEGATIVE, Nationality.BRA,
                        "51273669088", 55, new Dna(5L, "D4DF61C"), 5L, Boolean.FALSE, Boolean.FALSE),

                // Generate List for Colombia
                new Patient(6L, "Carlitos Tevez", "+57(11)2554-8547", BloodType.AB_POSITIVE, Nationality.COM,
                        "71606422014", 34, new Dna(6L, "CD65D8C"), 6L, Boolean.FALSE, Boolean.FALSE),
                new Patient(7L, "Carlitas Teresina", "+57(12)1254-1254", BloodType.B_NEGATIVE, Nationality.COM,
                        "60669180017", 13, new Dna(7L, "93F3D8B"), 7L, Boolean.TRUE, Boolean.TRUE),
                new Patient(8L, "Mariana Teresina", "+57(13)2544-8111", BloodType.O_POSITIVE, Nationality.COM,
                        "03356484010", 41, new Dna(8L, "8BE1489"), 8L, Boolean.FALSE, Boolean.FALSE),
                new Patient(9L, "Giulia Teresina", "+57(14)2554-8588", BloodType.O_POSITIVE, Nationality.COM,
                        "02558126040", 58, new Dna(9L, "D1DB5EA"), 9L, Boolean.TRUE, Boolean.FALSE),
                new Patient(10L, "Carlitositos Tevezitos", "+57(15)5474-2563", BloodType.A_NEGATIVE, Nationality.COM,
                        "29170060053", 62, new Dna(10L, "7B27BF5"), 10L, Boolean.FALSE, Boolean.FALSE),

                // Generate List for China
                new Patient(11L, "Maria maria", "+86(11)2554-8547", BloodType.O_NEGATIVE, Nationality.CHN,
                        "37069791011", 67, new Dna(11L, "0B8D992"), 11L, Boolean.TRUE, Boolean.TRUE),
                new Patient(12L, "China china", "+86(12)1254-1254", BloodType.B_NEGATIVE, Nationality.CHN,
                        "14792819059", 19, new Dna(12L, "AD77362"), 12L, Boolean.TRUE, Boolean.TRUE),
                new Patient(13L, "XenLong", "+86(13)2544-8111", BloodType.O_POSITIVE, Nationality.CHN,
                        "44602495028", 45, new Dna(13L, "2B5E823"), 13L, Boolean.FALSE, Boolean.FALSE),
                new Patient(14L, "Jack chan", "+86(14)2554-8588", BloodType.AB_NEGATIVE, Nationality.CHN,
                        "28941639085", 51, new Dna(14L, "FE7F0C6"), 14L, Boolean.TRUE, Boolean.FALSE),
                new Patient(15L, "K-POP", "+86(15)5474-2563", BloodType.A_NEGATIVE, Nationality.CHN,
                        "75850290044", 78, new Dna(15L, "2154A30"), 15L, Boolean.TRUE, Boolean.TRUE),

                // Generate List for Italia
                new Patient(16L, "Pizza Marguerite", "+39(11)2554-8547", BloodType.A_NEGATIVE, Nationality.ITA,
                        "61082395064", 26, new Dna(16L, "249BC35"), 16L, Boolean.FALSE, Boolean.FALSE),
                new Patient(17L, "China china", "+39(12)1254-1254", BloodType.B_NEGATIVE, Nationality.ITA,
                        "48952421027", 33, new Dna(17L, "A801917"), 17L, Boolean.TRUE, Boolean.FALSE),
                new Patient(18L, "XenLong", "+39(13)2544-8111", BloodType.O_POSITIVE, Nationality.ITA,
                        "50702784010", 36, new Dna(18L, "A96CB63"), 18L, Boolean.FALSE, Boolean.FALSE),
                new Patient(19L, "Jack chan", "+39(14)2554-8588", BloodType.A_POSITIVE, Nationality.ITA,
                        "26730549017", 44, new Dna(19L, "CE52A9F"), 19L, Boolean.TRUE, Boolean.FALSE),
                new Patient(20L, "K-POP", "+39(15)5474-2563", BloodType.A_NEGATIVE, Nationality.ITA,
                        "97595525071", 55, new Dna(20L, "1B4F11A"), 20L, Boolean.TRUE, Boolean.TRUE),

                // Generate List for Tunísia
                new Patient(21L, "Haythem", "+216(11)2554-8547", BloodType.A_NEGATIVE, Nationality.TUN,
                        "25953004079", 58, new Dna(21L, "C1859FD"), 21L, Boolean.FALSE, Boolean.FALSE),
                new Patient(22L, "Tuni tuni", "+216(12)1254-1254", BloodType.B_NEGATIVE, Nationality.TUN,
                        "99433250036", 22, new Dna(22L, "2D5632A"), 22L, Boolean.FALSE, Boolean.FALSE),
                new Patient(23L, "Putan", "+216(13)2544-8111", BloodType.O_POSITIVE, Nationality.TUN,
                        "50904030075", 23, new Dna(23L, "158EFCE"), 23L, Boolean.FALSE, Boolean.FALSE),
                new Patient(24L, "Miboun", "+216(14)2554-8588", BloodType.A_POSITIVE, Nationality.TUN,
                        "01751021041", 19, new Dna(24L, "5DD5E05"), 24L, Boolean.TRUE, Boolean.FALSE),
                new Patient(25L, "salamaleico", "+216(15)5474-2563", BloodType.A_NEGATIVE, Nationality.TUN,
                        "28308741029", 37, new Dna(25L, "77B48AD"), 25L, Boolean.TRUE, Boolean.TRUE)
        );

        patients.forEach(patient -> calculateRiskAge(patient));

        return patients;
    }

    @Override
    public void calculateRiskAge(Patient patient){
        Integer age = patient.getAge();

        if(age >= 0 && age <= 20){
            patient.setRisk(Risk.LOW);
        }
        if(age >= 25 && age <= 35){
            patient.setRisk(Risk.MEDIUM);
        }
        else if(age > 35){
            patient.setRisk(Risk.HIGH);
        }
    }
}
