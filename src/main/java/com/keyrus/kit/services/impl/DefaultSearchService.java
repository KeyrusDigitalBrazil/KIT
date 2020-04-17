package com.keyrus.kit.services.impl;

import com.keyrus.kit.context.Context;
import com.keyrus.kit.exceptions.BloodTypeException;
import com.keyrus.kit.exceptions.NationalityException;
import com.keyrus.kit.filter.PersonFilter;
import com.keyrus.kit.filter.impl.DefaultPersonFilter;
import com.keyrus.kit.models.Patient;
import com.keyrus.kit.search.SearchStrategy;
import com.keyrus.kit.search.impl.*;
import com.keyrus.kit.services.DefaultJdbcService;
import com.keyrus.kit.services.JdbcService;
import com.keyrus.kit.services.PersonService;
import com.keyrus.kit.services.SearchService;
import com.keyrus.kit.utils.DatabaseConnect;
import com.keyrus.kit.utils.MenuUtils;
import com.keyrus.kit.utils.SystemUtils;
import com.keyrus.kit.utils.impl.DefaultMenuUtils;
import com.keyrus.kit.utils.impl.DefaultSystemUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class DefaultSearchService implements SearchService {

    private static JdbcService jdbcService = new DefaultJdbcService();

    private PersonService personService = new DefaultPersonService();
    private PersonFilter personFilter = new DefaultPersonFilter();
    private MenuUtils menuUtils = new DefaultMenuUtils();
    private SystemUtils systemUtils = new DefaultSystemUtils();

    private static final String OBSERVER = "observer";
    private static final String STRATEGY = "strategy";

    @Override
    public void baseSearch() {
        teste();

        generateData();

        String option = "";

        while (!option.equals("0")) {
            generateInitialMenu();

            option = systemUtils.generateStringScanner();

            String pattern = systemUtils.getPropertiesValue("pattern.selector");

            if (pattern.equals(OBSERVER)) {
                patternObserver(option);
            } else if (pattern.equals(STRATEGY)) {
                patternStrategy(option);
            } else {
                //Default pattern
                patternStrategy(option);
            }

        }
    }

    private void patternStrategy(String option) {
        try {
            switch (option) {
                case "1" -> new Context(new DocSearch(personFilter));
                case "2" -> new Context(new DnaSearch(personFilter));
                case "3" -> new Context(new InfectedSearch(personFilter));
                case "4" -> new Context(new SuspiciousSearch(personFilter));
                case "5" -> new Context(new NotInfectedSearch(personFilter));
                case "6" -> new Context(new BloodyTypeSearch(personFilter));
                case "7" -> new Context(new SearchAllSearch(personFilter));
                case "0" -> System.out.println("Thanks for your time");
                default -> menuUtils.showInput();
            }
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

    private void patternObserver(String option) {
        try {
            int opt = Integer.parseInt(option);

            if (opt == 0) {
                System.out.println("Thanks for your time");
                return;
            }

            List<SearchStrategy> searchStrategies = Arrays.asList(new DocSearch(personFilter), new DnaSearch(personFilter), new InfectedSearch(personFilter),
                    new SuspiciousSearch(personFilter), new NotInfectedSearch(personFilter), new BloodyTypeSearch(personFilter),
                    new SearchAllSearch(personFilter));

            if (opt - 1 > searchStrategies.size() || opt - 1 < 0) {
                menuUtils.showInput();
                return;
            }

            searchStrategies.get(opt - 1).search();
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

    @Override
    public void generateInitialMenu() {
        menuUtils.showMenuPrincipal();
    }

    @Override
    public void generateData() {
        Set<Patient> patients = personService.generatorPatient();

        personFilter.setPatientList(patients);
    }

    public void teste() {
        try {
            DatabaseConnect jdbcConn = DatabaseConnect.getInstance();
            System.out.println("Mysql Connected? " + jdbcConn.checkConnection());
            jdbcConn.closeConnection();

            jdbcService.selectAll(new Patient()).forEach(System.out::println);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
