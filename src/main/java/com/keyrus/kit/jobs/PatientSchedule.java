package com.keyrus.kit.jobs;

import com.keyrus.kit.models.Patient;
import com.keyrus.kit.repository.KitRepository;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@EnableScheduling
@EnableAsync
public class PatientSchedule {

    @Resource(name = "patientRepository")
    private KitRepository patientRepository;

    private Random randBool = new Random();

    @Scheduled(fixedDelayString = "${quarantine.schedule.ms}")
    @Async
    public void checkQuarantine() {
        List<Patient> patientList = patientRepository.getAll();

        patientList.stream().filter(Objects::nonNull)
                .forEach(patient -> {
                    if (patient.getSuspicious().equals(Boolean.TRUE)) {
                        boolean value = randBool.nextBoolean();
                        if (value) {
                            if (BooleanUtils.isNotTrue(patient.getQuarantine())) {
                                patient.setQuarantine(Boolean.TRUE);
                                patientRepository.update(patient);
                            }
                        } else {
                            if (BooleanUtils.isTrue(patient.getQuarantine())) {
                                patient.setQuarantine(Boolean.FALSE);
                                patientRepository.update(patient);
                            }
                        }
                    }
                });


    }


}
