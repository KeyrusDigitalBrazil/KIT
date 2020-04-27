package com.keyrus.kit.context;

import com.keyrus.kit.search.SearchStrategy;

public class Context {

    public Context(SearchStrategy searchStrategy) {
        searchStrategy.search();
    }

}
