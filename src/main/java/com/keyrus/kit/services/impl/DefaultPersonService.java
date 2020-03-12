package com.keyrus.kit.services.impl;

import com.keyrus.kit.models.Dna;
import com.keyrus.kit.models.Patient;
import com.keyrus.kit.models.enums.BloodType;
import com.keyrus.kit.models.enums.Nationality;
import com.keyrus.kit.services.PersonService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DefaultPersonService implements PersonService {

    public List<Patient> generatorPatient(){
        List<Patient> patients = Arrays.asList(

                // Generate List for Brazil
                new Patient(1L,"José Alves", "+55(11)91234-5678", BloodType.A_NEGATIVE, Nationality.BRA,
                        "081.723.670-82",25, new Dna(1L,"3D8F825"),1L,Boolean.FALSE,Boolean.FALSE),
                new Patient(2L,"Haythem Chutador de Anão", "+55(13)94325-8547", BloodType.AB_POSITIVE, Nationality.BRA,
                        "528.720.710-75",34, new Dna(2L,"AC0C4F6"),2L,Boolean.FALSE,Boolean.FALSE),
                new Patient(3L,"Mariana Clara", "+55(15)98574-2369", BloodType.B_POSITIVE, Nationality.BRA,
                        "159.502.630-49",54, new Dna(3L,"5B2B137"),3L,Boolean.TRUE,Boolean.FALSE),
                new Patient(4L,"Clara Mariana", "+55(21)95841-2100", BloodType.AB_POSITIVE, Nationality.BRA,
                        "800.529.540-56",34, new Dna(4L,"60C975F"),4L,Boolean.TRUE,Boolean.FALSE),
                new Patient(5L,"Haythem Chutador de Anão", "+55(12)94325-8547", BloodType.AB_POSITIVE, Nationality.BRA,
                        "512.736.690-88",34, new Dna(5L,"D4DF61C"),5L,Boolean.FALSE,Boolean.FALSE),

                // Generate List for Colombia
                new Patient(6L,"Carlitos Tevez", "+57(11)2554-8547", BloodType.AB_POSITIVE, Nationality.COM,
                        "512.736.690-88",34, new Dna(6L,"CD65D8C"),6L,Boolean.FALSE,Boolean.FALSE),
                new Patient(7L,"Carlitas Teresina", "+57(12)1254-1254", BloodType.B_NEGATIVE, Nationality.COM,
                        "512.736.690-88",34, new Dna(7L,"93F3D8B"),7L,Boolean.TRUE,Boolean.TRUE),
                new Patient(8L,"Mariana Teresina", "+57(13)2544-8111", BloodType.O_POSITIVE, Nationality.COM,
                        "512.736.690-88",34, new Dna(8L,"8BE1489"),8L,Boolean.FALSE,Boolean.FALSE),
                new Patient(9L,"Giulia Teresina", "+57(14)2554-8588", BloodType.O_POSITIVE, Nationality.COM,
                        "512.736.690-88",34, new Dna(9L,"D1DB5EA"),9L,Boolean.TRUE,Boolean.FALSE),
                new Patient(10L,"Carlitositos Tevezitos", "+57(15)5474-2563", BloodType.A_NEGATIVE, Nationality.COM,
                        "512.736.690-88",34, new Dna(10L,"7B27BF5"),10L,Boolean.FALSE,Boolean.FALSE)
        );

        return patients;
    }
}
