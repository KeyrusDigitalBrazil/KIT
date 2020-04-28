package com.keyrus.kit.controllers;

import com.keyrus.kit.convert.PatientConvert;
import com.keyrus.kit.data.PatientData;
import com.keyrus.kit.models.Patient;
import com.keyrus.kit.repository.KitRepository;
import com.keyrus.kit.services.KafkaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

@RestController
@RequestMapping(value = "/patient")
@Slf4j
public class PatientController {

    @Resource(name = "patientRepository")
    private KitRepository patientRepository;

    @Resource
    private PatientConvert patientConvert;

    @Resource
    private KafkaService kafkaService;

    @Value("${kafka.patient.save.topic}")
    private String saveTopic;

    @Value("${kafka.patient.update.topic}")
    private String updateTopic;

    @Value("${kafka.patient.delete.topic}")
    private String deleteTopic;

    @GetMapping(value = "/{id}")
    @ResponseBody
    public PatientData getPatient(@PathVariable Long id) {
        Optional<Patient> optPatient = Optional.ofNullable((Patient) patientRepository.get(id));

        return optPatient.map(patient -> patientConvert.convertModel(patient)).orElse(null);
    }

    @GetMapping(value = "/all")
    @ResponseBody
    public Set<PatientData> getAll() {
        Optional<List<Patient>> optPatient = Optional.ofNullable((List<Patient>) patientRepository.getAll());
        Set<PatientData> patientData = new TreeSet<>();

        optPatient.ifPresent(patients -> patients.stream()
                .filter(Objects::nonNull)
                .forEach(patient -> patientData.add(patientConvert.convertModel(patient))));

        return patientData;
    }

    @PostMapping
    public HttpStatus savePatient(@RequestBody PatientData patientData) {
        try {
            patientRepository.add(patientConvert.convertData(patientData));
            log.info("Saving Patient");
            kafkaService.sendMessage(saveTopic, patientData);
            log.info("Sending saved Patient");
            return HttpStatus.OK;
        } catch (Exception e) {
            return HttpStatus.BAD_REQUEST;
        }
    }

    @PutMapping
    public HttpStatus updatePatient(@RequestBody PatientData patientData) {
        try {
            patientRepository.update(patientConvert.convertData(patientData));
            log.info("Updating Patient");
            kafkaService.sendMessage(updateTopic, patientData);
            log.info("Sending updated Patient");
            return HttpStatus.OK;
        } catch (Exception e) {
            return HttpStatus.BAD_REQUEST;
        }
    }

    @DeleteMapping(value = "/{id}")
    public HttpStatus deletePatient(@PathVariable Long id) {
        try {
            Optional<Patient> optPatient = Optional.ofNullable((Patient) patientRepository.get(id));
            patientRepository.remove(id);
            log.info("Deleting Patient");
            if (optPatient.isPresent()) {
                kafkaService.sendMessage(deleteTopic, patientConvert.convertModel(optPatient.get()));
                log.info("Sending deleted Patient");
            }
            return HttpStatus.OK;
        } catch (Exception e) {
            return HttpStatus.BAD_REQUEST;
        }
    }

}
