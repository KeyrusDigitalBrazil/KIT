package com.keyrus.kit.filter;

import com.keyrus.kit.builder.PatientBuilderTest;
import com.keyrus.kit.data.PatientDnaData;
import com.keyrus.kit.filter.impl.DefaultPersonFilter;
import com.keyrus.kit.models.Patient;
import org.junit.Before;
import org.junit.Test;

import static com.keyrus.kit.models.enums.BloodType.*;
import static com.keyrus.kit.models.enums.Nationality.*;
import static org.junit.Assert.*;


public class DefaultPersonFilterTest {

    private DefaultPersonFilter defaultPersonFilter;
    private DefaultPersonFilter defaultPersonFilterEmpty;
    private Patient patient;
    private PatientDnaData patientDnaData;

    @Before
    public void setUp() {
        defaultPersonFilter = new DefaultPersonFilter();
        defaultPersonFilterEmpty = new DefaultPersonFilter();
        patient = PatientBuilderTest.defaultValues();
        defaultPersonFilter.setPatientList(PatientBuilderTest.patientBuilderList());
        defaultPersonFilterEmpty.setPatientList(PatientBuilderTest.patientBuilderListEmpty());
        patientDnaData = new PatientDnaData(patient, patient.getDna());
    }

    @Test
    public void getPersonByDocSuccess() {
        assertEquals(defaultPersonFilter.getPersonByDoc("08172367082").toString(), patient.toString());
    }

    @Test
    public void getPersonByDocFail() {
        assertNull(defaultPersonFilter.getPersonByDoc("1111111"));
    }


    @Test
    public void getDnaByIdSuccess() {
        assertEquals(defaultPersonFilter.getDnaById(1L).toString(), patientDnaData.toString());
    }

    @Test
    public void getDnaByIdFail() {
        assertNotNull(defaultPersonFilter.getDnaById(2L));
    }

    @Test
    public void getDnaByCodeSuccess() {
        assertEquals(defaultPersonFilter.getDnaByCode("3D8F825").toString(), patientDnaData.toString());
    }

    @Test
    public void getDnaByCodeFail() {
        assertNotNull(defaultPersonFilter.getDnaByCode("111111"));
    }

    @Test
    public void getInfectedSuccess() {
        assertTrue(defaultPersonFilter.getInfected().size() > 0);
    }

    @Test
    public void getInfectedFail() {
        assertTrue(defaultPersonFilterEmpty.getInfected().isEmpty());
    }

    @Test
    public void getInfectedByNationalitySuccess() {
        assertTrue(defaultPersonFilter.getInfectedByNationality(CHN).size() > 0);
    }

    @Test
    public void getInfectedByNationalityFail() {
        assertTrue(defaultPersonFilter.getInfectedByNationality(CA).isEmpty());
    }

    @Test
    public void getSuspiciousSuccess() {
        assertTrue(defaultPersonFilter.getSuspicious().size() > 0);
    }

    @Test
    public void getSuspiciousFail() {
        assertTrue(defaultPersonFilterEmpty.getSuspicious().isEmpty());
    }

    @Test
    public void cleanStringSucess() {
        assertEquals("08172367082", defaultPersonFilter.cleanString("081.72..;3.//6\\70-82"));
    }

    @Test
    public void cleanStringFail() {
        assertNotEquals("08172367082", defaultPersonFilter.cleanString("081.723.670AAAAAA-82"));
    }

    @Test
    public void getSuspiciousByNationalitySuccess() {
        assertTrue(defaultPersonFilter.getSuspiciousByNationality(CHN).size() > 0);
    }

    @Test
    public void getSuspiciousByNationalityFail() {
        assertTrue(defaultPersonFilterEmpty.getSuspiciousByNationality(CHN).isEmpty());
    }

    @Test
    public void getNotInfectedSuccess() {
        assertTrue(defaultPersonFilter.getNotInfected().size() > 0);
    }

    @Test
    public void getNotInfectedFail() {
        assertTrue(defaultPersonFilterEmpty.getNotInfected().isEmpty());
    }

    @Test
    public void getNotInfectedByNationalitySuccess() {
        assertTrue(defaultPersonFilter.getNotInfectedByNationality(BRA).size() > 0);
    }

    @Test
    public void getNotInfectedByNationalityFail() {
        assertTrue(defaultPersonFilterEmpty.getNotInfectedByNationality(BRA).isEmpty());
    }

    @Test
    public void getPatientCombineByBloodSuccess() {
        assertTrue(defaultPersonFilter.getPatientCombineByBlood(A_NEGATIVE).size() > 0);
    }

    @Test
    public void getPatientCombineByBloodFail() {
        assertTrue(defaultPersonFilterEmpty.getPatientCombineByBlood(A_NEGATIVE).isEmpty());
    }

    @Test
    public void getPatientCombineByBloodAndNationalitySuccess() {
        assertTrue(defaultPersonFilter.getPatientCombineByBloodAndNationality(A_NEGATIVE, BRA).size() > 0);
    }

    @Test
    public void getPatientCombineByBloodAndNationalityFail() {
        assertTrue(defaultPersonFilterEmpty.getPatientCombineByBloodAndNationality(A_NEGATIVE, BRA).isEmpty());
    }

    @Test
    public void getPatientAllSuccess() {
        assertTrue(defaultPersonFilter.getPatientAll().size() > 0);
    }

    @Test
    public void getPatientAllFail() {
        assertTrue(defaultPersonFilterEmpty.getPatientAll().isEmpty());
    }
}