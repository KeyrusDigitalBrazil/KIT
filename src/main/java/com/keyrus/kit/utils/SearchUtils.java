package com.keyrus.kit.utils;

import com.keyrus.kit.models.Patient;

import java.util.Set;

public interface SearchUtils {

    /**
     * Validate to return result or empty
     *
     * @param object
     */
    void validEmptyResult(Object object);

    /**
     * Validate to return result list or empty
     *
     * @param patients
     */
    void validEmptyResultList(Set<Patient> patients);

}
