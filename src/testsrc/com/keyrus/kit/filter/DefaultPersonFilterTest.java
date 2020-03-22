package com.keyrus.kit.filter;

import com.keyrus.kit.filter.impl.DefaultPersonFilter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DefaultPersonFilterTest {

    private DefaultPersonFilter defaultPersonFilter;

    @Before
    public void setUp() {
        defaultPersonFilter = new DefaultPersonFilter();
    }

    @Test
    public void getPersonByDocTestFail() {
        Assert.assertNull(defaultPersonFilter.getPersonByDoc("08172367081"));
    }
}
