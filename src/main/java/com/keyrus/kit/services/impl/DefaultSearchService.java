package com.keyrus.kit.services.impl;

import com.keyrus.kit.context.Context;
import com.keyrus.kit.exceptions.BloodTypeException;
import com.keyrus.kit.exceptions.NationalityException;
import com.keyrus.kit.filter.PersonFilter;
import com.keyrus.kit.filter.impl.DefaultPersonFilter;
import com.keyrus.kit.models.Patient;
import com.keyrus.kit.search.SearchStrategy;
import com.keyrus.kit.search.impl.*;
import com.keyrus.kit.services.PersonService;
import com.keyrus.kit.services.SearchService;
import com.keyrus.kit.utils.MenuUtils;
import com.keyrus.kit.utils.SystemUtils;
import com.keyrus.kit.utils.impl.DefaultMenuUtils;
import com.keyrus.kit.utils.impl.DefaultSystemUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class DefaultSearchService implements SearchService {

    private PersonService personService = new DefaultPersonService();
    private PersonFilter personFilter = new DefaultPersonFilter();
    private MenuUtils menuUtils = new DefaultMenuUtils();
    private SystemUtils systemUtils = new DefaultSystemUtils();
    private Context context;

    @Override
    public void baseSearch() {
        generateData();

        String option = "";

        while (!option.equals("0")) {
            generateInitialMenu();

            option = systemUtils.generateStringScanner();
            List<SearchStrategy> searchStrategies = new ArrayList<>();
            searchStrategies = Arrays.asList(   new DocSearch(personFilter), new DnaSearch(personFilter), new InfectedSearch(personFilter),
                                                new SuspiciousSearch(personFilter), new NotInfectedSearch(personFilter), new BloodyTypeSearch(personFilter),
                                                new SearchAllSearch(personFilter));
            for (int i = Integer.valueOf(option) -1; i < searchStrategies.size(); i++) {
                searchStrategies.get(i).search();

            }
            try {
//                switch (option) {
//                    case "1" -> context = new Context(new DocSearch(personFilter));
//                    case "2" -> context = new Context(new DnaSearch(personFilter));
//                    case "3" -> context = new Context(new InfectedSearch(personFilter));
//                    case "4" -> context = new Context(new SuspiciousSearch(personFilter));
//                    case "5" -> context = new Context(new NotInfectedSearch(personFilter));
//                    case "6" -> context = new Context(new BloodyTypeSearch(personFilter));
//                    case "7" -> context = new Context(new SearchAllSearch(personFilter));
//                    case "0" -> System.out.println("Thanks for your time");
//                    default -> menuUtils.showInput();
//                }
            } catch (NumberFormatException e) {
                menuUtils.showErrorNumber();
                menuUtils.showException(e.toString());
            } catch (BloodTypeException e) {
                menuUtils.showErrorBloodType();
                menuUtils.showException(e.toString());
            } catch (NationalityException e) {
                menuUtils.showErrorCountry();
                menuUtils.showException(e.toString());
            } catch (Exception e) {
                menuUtils.showError();
                menuUtils.showException(e.toString());
            }

        }
    }

    @Override
    public void generateInitialMenu() {
        menuUtils.showMenuPrincipal();
    }

    @Override
    public void generateData() {
        Set<Patient> patients = personService.generatorPatient();

        personFilter.setPatientList(patients);
    }

}
