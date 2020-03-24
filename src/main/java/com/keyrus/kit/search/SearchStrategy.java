package com.keyrus.kit.search;

import com.keyrus.kit.filter.PersonFilter;

public interface SearchStrategy {

    void search();

    void setPersonFilter(PersonFilter personFilter);
}
