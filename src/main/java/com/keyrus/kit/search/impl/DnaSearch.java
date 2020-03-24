package com.keyrus.kit.search.impl;

import com.keyrus.kit.filter.PersonFilter;
import com.keyrus.kit.filter.impl.DefaultPersonFilter;
import com.keyrus.kit.search.SearchStrategy;
import com.keyrus.kit.utils.MenuUtils;
import com.keyrus.kit.utils.SearchUtils;
import com.keyrus.kit.utils.SystemUtils;
import com.keyrus.kit.utils.impl.DefaultMenuUtils;
import com.keyrus.kit.utils.impl.DefaultSearchUtils;
import com.keyrus.kit.utils.impl.DefaultSystemUtils;

public class DnaSearch implements SearchStrategy {

    private PersonFilter personFilter = new DefaultPersonFilter();
    private MenuUtils menuUtils = new DefaultMenuUtils();
    private SearchUtils searchUtils = new DefaultSearchUtils();
    private SystemUtils systemUtils = new DefaultSystemUtils();

    @Override
    public void search() {
        menuUtils.showMenusSearchByDnaOpt();
        switch (systemUtils.generateStringScanner()) {
            case "1":
                menuUtils.showMenusSearchByDna();
                String str = systemUtils.generateStringScanner();
                searchUtils.validEmptyResult(personFilter.getDnaById(Long.parseLong(str)));
                break;
            case "2":
                menuUtils.showMenusSearchByDnaCode();
                searchUtils.validEmptyResult(personFilter.getDnaByCode(systemUtils.generateStringScanner()));
                break;
            case "0":
                break;
            default:
                menuUtils.showInput();
                this.search();
        }
    }

    @Override
    public void setPersonFilter(PersonFilter filter) {
        personFilter = filter;
    }

}
