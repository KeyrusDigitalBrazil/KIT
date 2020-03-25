package com.keyrus.kit.utils;

import com.keyrus.kit.filter.PersonFilter;

public interface PersonUtils {

    /**
     * Search patient by DOC
     *
     * @param doc
     */
    void searchByDoc(String doc);

    /**
     * Generate section for search all patients
     */
    void searchAllPatients();

    /**
     * Transport list
     */
    void setPersonFilter(PersonFilter personFilter);

}
