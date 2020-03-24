package com.keyrus.kit.search.impl;

import com.keyrus.kit.search.SearchStrategy;

public class DnaSearch implements SearchStrategy {

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

}
