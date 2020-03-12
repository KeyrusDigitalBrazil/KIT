package com.keyrus.kit.filter;

import com.keyrus.kit.models.Dna;
import com.keyrus.kit.models.Person;

import java.util.List;

public interface PersonService {

    Person getPersonByDoc(String doc);

    Dna getDnaById(Long id);

    List<Person> getInfected();

    List<Person> getInfectedByNationality();

    List<Person> getSuspicious();

    List<Person> getSuspiciousByNationality();

    List<Person> getNotInfected();

    List<Person> getNotInfectedByNationality();

    List<Person> getPatientCombineByBlood();

    List<Person> getPatientCombineByBloodAndNationality();

}
