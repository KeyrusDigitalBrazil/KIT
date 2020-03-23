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
        if (object instanceof Patient) {
            try {
                if (((Patient) object).checkNull()) {
                    menuUtils.showEmptyResult();
                    return;
                } else {
                    personService.validQuarantine((Patient) object);
                    System.out.println(((Patient) object).toPrint());
                    return;
                }
            } catch (Exception e) {
                menuUtils.showError();
                return;
            }
        }

        if (object instanceof Dna || object instanceof PatientDnaData) {
            if (object == null) {
                menuUtils.showEmptyResult();
            } else {
                System.out.println(object);
            }
        } else {
            menuUtils.showError();
        }
    }

    @Override
    public void validEmptyResultList(Set<Patient> patients) {
        if (patients.isEmpty()) {
            menuUtils.showEmptyResult();
        } else {
            patients.forEach(this::accept);
            patients.forEach(System.out::println);
        }
    }

    private void accept(Patient patient) {
        personService.validQuarantine(patient);
    }
}
