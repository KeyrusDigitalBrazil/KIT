package com.keyrus.kit.search;

import com.keyrus.kit.filter.PersonFilter;
import com.keyrus.kit.filter.impl.DefaultPersonFilter;
import com.keyrus.kit.services.PersonService;
import com.keyrus.kit.services.impl.DefaultPersonService;
import com.keyrus.kit.utils.MenuUtils;
import com.keyrus.kit.utils.PersonUtils;
import com.keyrus.kit.utils.SearchUtils;
import com.keyrus.kit.utils.SystemUtils;
import com.keyrus.kit.utils.impl.DefaultMenuUtils;
import com.keyrus.kit.utils.impl.DefaultPersonUtils;
import com.keyrus.kit.utils.impl.DefaultSearchUtils;
import com.keyrus.kit.utils.impl.DefaultSystemUtils;

public interface SearchStrategy {

     PersonService personService = new DefaultPersonService();
     PersonFilter personFilter = new DefaultPersonFilter();
     MenuUtils menuUtils = new DefaultMenuUtils();
     SearchUtils searchUtils = new DefaultSearchUtils();
     PersonUtils personUtils = new DefaultPersonUtils();
     SystemUtils systemUtils = new DefaultSystemUtils();

    void search();
}
