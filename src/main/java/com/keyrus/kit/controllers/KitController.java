package com.keyrus.kit.controllers;

import com.keyrus.kit.convert.PatientConvert;
import com.keyrus.kit.data.PatientData;
import com.keyrus.kit.models.Patient;
import com.keyrus.kit.repository.KitRepository;
import com.keyrus.kit.repository.impl.AppKitRepository;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping(value = "/kit")
public class KitController {

    @Resource(name = "appKitRepository")
    private AppKitRepository appKitRepository;

    @Resource(name = "patientRepository")
    private KitRepository patientRepository;

    @Resource
    private PatientConvert patientConvert;

    @GetMapping(value = "/doc/{doc}")
    @ResponseBody
    public PatientData findByDoc(@PathVariable String doc) {
        Optional<Patient> optPatient = Optional.ofNullable(appKitRepository.getByDoc(doc.replaceAll("[^a-zA-Z0-9]", "")));
        return optPatient.map(patient -> patientConvert.convertModel(patient)).orElse(null);
    }

    @GetMapping(value = "/dna/{dna}")
    @ResponseBody
    public PatientData findByDna(@PathVariable String dna) {
        Optional<Patient> optPatient = Optional.ofNullable(appKitRepository.getByDna(dna));
        return optPatient.map(patient -> patientConvert.convertModel(patient)).orElse(null);
    }

    @GetMapping(value = "/infected")
    @ResponseBody
    public List<PatientData> findByInfected(@RequestParam(required = false) String nationality) {
        Optional<List<Patient>> optPatient = Optional.ofNullable(appKitRepository.getInfected(nationality));

        List<PatientData> patientData = new ArrayList<>();

        optPatient.ifPresent(patients -> patients.stream()
                .filter(Objects::nonNull)
                .forEach(patient -> patientData.add(patientConvert.convertModel(patient))));

        return patientData;
    }

    @GetMapping(value = "/suspicious")
    @ResponseBody
    public List<PatientData> findBySuspicious(@RequestParam(required = false) String nationality) {
        Optional<List<Patient>> optPatient = Optional.ofNullable(appKitRepository.getSuspicious(nationality));

        List<PatientData> patientData = new ArrayList<>();

        optPatient.ifPresent(patients -> patients.stream()
                .filter(Objects::nonNull)
                .forEach(patient -> patientData.add(patientConvert.convertModel(patient))));

        return patientData;
    }

    @GetMapping(value = "/notinfected")
    @ResponseBody
    public List<PatientData> findByNotInfected(@RequestParam(required = false) String nationality) {
        Optional<List<Patient>> optPatient = Optional.ofNullable(appKitRepository.getNotInfected(nationality));

        List<PatientData> patientData = new ArrayList<>();

        optPatient.ifPresent(patients -> patients.stream()
                .filter(Objects::nonNull)
                .forEach(patient -> patientData.add(patientConvert.convertModel(patient))));

        return patientData;
    }

    @GetMapping(value = "/blood")
    @ResponseBody
    public List<PatientData> findByBloodType(@RequestParam String bloodType, @RequestParam(required = false) String nationality) {
        Optional<List<Patient>> optPatient = Optional.ofNullable(appKitRepository.getBloodType(bloodType, nationality));

        List<PatientData> patientData = new ArrayList<>();

        optPatient.ifPresent(patients -> patients.stream()
                .filter(Objects::nonNull)
                .forEach(patient -> patientData.add(patientConvert.convertModel(patient))));

        return patientData;
    }

    @GetMapping(value = "/all")
    @ResponseBody
    public List<PatientData> findByAll(@RequestParam(required = false) String nationality) {
        Optional<List<Patient>> optPatient = Optional.ofNullable(patientRepository.getAll());

        List<PatientData> patientData = new ArrayList<>();

        optPatient.ifPresent(patients -> patients.stream()
                .filter(Objects::nonNull)
                .forEach(patient -> patientData.add(patientConvert.convertModel(patient))));

        return patientData;
    }

}
