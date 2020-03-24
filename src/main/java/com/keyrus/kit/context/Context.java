package com.keyrus.kit.context;

import com.keyrus.kit.search.SearchStrategy;

public class Context {
    private SearchStrategy searchStrategy;

    public Context (SearchStrategy searchStrategy){
        this.searchStrategy = searchStrategy;
    }

    public void executeStrategy(){
        searchStrategy.search();
    }
}
