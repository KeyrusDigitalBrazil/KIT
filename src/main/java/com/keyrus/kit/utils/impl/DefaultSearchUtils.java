package com.keyrus.kit.utils.impl;

import com.keyrus.kit.data.PatientDnaData;
import com.keyrus.kit.models.Dna;
import com.keyrus.kit.models.Patient;
import com.keyrus.kit.services.PersonService;
import com.keyrus.kit.services.impl.DefaultPersonService;
import com.keyrus.kit.utils.MenuUtils;
import com.keyrus.kit.utils.SearchUtils;

import java.util.Set;

public class DefaultSearchUtils implements SearchUtils {

    private PersonService personService = new DefaultPersonService();
    private MenuUtils menuUtils = new DefaultMenuUtils();

    @Override
    public void validEmptyResult(Object object) {
        try {
            if (object instanceof Patient patient) {
                if (patient.checkNull()) {
                    menuUtils.showEmptyResult();
                } else {
                    personService.validQuarantine(patient);
                    System.out.println(patient.toPrint());
                }
            }
            if (object instanceof Dna dna) {
                if (dna.checkNull()) {
                    menuUtils.showEmptyResult();
                } else {
                    System.out.println(dna.toPrint());
                }
            }
            if (object instanceof PatientDnaData dnaData) {
                if (dnaData.checkNull()) {
                    menuUtils.showEmptyResult();
                } else {
                    System.out.println(dnaData.toPrint());
                }
            }

        } catch (Exception e) {
            menuUtils.showError();
        }

    }

    @Override
    public void validEmptyResultList(Set<Patient> patients) {
        if (patients.isEmpty()) {
            menuUtils.showEmptyResult();
        } else {
            patients.forEach(this::accept);
            patients.forEach(patient -> System.out.println(patient.toPrint()));
        }
    }

    private void accept(Patient patient) {
        personService.validQuarantine(patient);
    }
}
