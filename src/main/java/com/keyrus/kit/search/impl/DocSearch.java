package com.keyrus.kit.search.impl;

import com.keyrus.kit.filter.PersonFilter;
import com.keyrus.kit.models.Patient;
import com.keyrus.kit.search.SearchStrategy;
import com.keyrus.kit.utils.MenuUtils;
import com.keyrus.kit.utils.SearchUtils;
import com.keyrus.kit.utils.SystemUtils;
import com.keyrus.kit.utils.impl.DefaultMenuUtils;
import com.keyrus.kit.utils.impl.DefaultSearchUtils;
import com.keyrus.kit.utils.impl.DefaultSystemUtils;

public class DocSearch implements SearchStrategy {

    private PersonFilter personFilter;
    private MenuUtils menuUtils = new DefaultMenuUtils();
    private SearchUtils searchUtils = new DefaultSearchUtils();
    private SystemUtils systemUtils = new DefaultSystemUtils();


    public DocSearch(PersonFilter personFilter) {
        this.personFilter = personFilter;
    }

    @Override
    public void search() {
        menuUtils.showMenusSearchByDoc();
        String doc = systemUtils.generateStringScanner();
        Patient patient = personFilter.getPersonByDoc(doc) == null ? new Patient() : personFilter.getPersonByDoc(doc);
        searchUtils.validEmptyResult(patient);
    }

}
