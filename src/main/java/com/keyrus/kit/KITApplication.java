package com.keyrus.kit;

import com.keyrus.kit.models.Dna;
import com.keyrus.kit.models.Patient;
import com.keyrus.kit.repository.KitRepository;
import com.keyrus.kit.services.PersonService;
import com.keyrus.kit.services.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.DriverManager;
import java.util.List;
import java.util.Set;

@SpringBootApplication
@Slf4j
public class KITApplication {

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.port}")
    private String port;

    @Value("${jdbc.database}")
    private String database;

    @Value("${jdbc.user}")
    private String user;

    @Value("${jdbc.password}")
    private String password;

    @Value("${enable.console.application}")
    private boolean enableConsole;

    @Resource
    ResourceLoader resourceLoader;

    @Resource
    private SearchService searchService;

    @Resource
    private PersonService personService;

    @Resource(name = "patientRepository")
    private KitRepository patientRepository;

    @Resource(name = "dnaRepository")
    private KitRepository dnaRepository;

    public static void main(String[] args) {
        SpringApplication.run(KITApplication.class, args);
    }

    @PostConstruct
    public void start() throws Exception {
        init();
        if (enableConsole) searchService.baseSearch();
        startData();
    }

    public void init() throws Exception {
        ScriptRunner scriptRunner = new ScriptRunner(
                DriverManager.getConnection("jdbc:mysql://" + url + ":" + port + "/" + database, user, password));

        scriptRunner.runScript(new BufferedReader(new FileReader(resourceLoader.getResource("classpath:db/tables.sql").getFile())));
    }

    public void startData() {
        try {
            List<Patient> patientList = patientRepository.getAll();

            if (CollectionUtils.isEmpty(patientList)) {
                List<Dna> dnaList = dnaRepository.getAll();

                dnaList.forEach(dna -> dnaRepository.remove(dna.getId()));

                Set<Patient> patients = personService.generatorPatient();

                patients.stream()
                        .map(patient -> new Dna(patient.getDna().getId(), patient.getDna().getDna()))
                        .forEach(dna -> dnaRepository.add(dna));

                patients.forEach(patient -> patientRepository.add(patient));
            }
        } catch (Exception e) {
            log.error("Error on create initial data {}", e.getMessage());
        }
    }

}
