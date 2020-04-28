package com.keyrus.kit.filter;

import com.keyrus.kit.builder.PatientBuilderTest;
import com.keyrus.kit.convert.DnaConvert;
import com.keyrus.kit.convert.PatientConvert;
import com.keyrus.kit.data.PatientDnaData;
import com.keyrus.kit.filter.impl.DefaultPersonFilter;
import com.keyrus.kit.models.Patient;
import org.junit.Before;
import org.junit.Test;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

import static com.keyrus.kit.models.enums.BloodType.A_NEGATIVE;
import static com.keyrus.kit.models.enums.Nationality.*;
import static org.junit.Assert.*;

@Component
public class DefaultPersonFilterTest {

    private DefaultPersonFilter defaultPersonFilter;
    private DefaultPersonFilter defaultPersonFilterEmpty;
    private Patient patient;
    private PatientDnaData patientDnaData;

    private PatientConvert patientConvert = new PatientConvert();

    private DnaConvert dnaConvert = new DnaConvert();

    @Before
    public void setUp() {
        defaultPersonFilter = new DefaultPersonFilter();
        defaultPersonFilterEmpty = new DefaultPersonFilter();
        patient = PatientBuilderTest.defaultValues();
        defaultPersonFilter.setPatientList(PatientBuilderTest.patientBuilderList());
        defaultPersonFilterEmpty.setPatientList(PatientBuilderTest.patientBuilderListEmpty());
    }

    @Test
    public void getPersonByDocSuccess() {
        assertEquals(defaultPersonFilter.getPersonByDoc("08172367082").toPrint(), patient.toPrint());
    }

    @Test
    public void getPersonByDocFail() {
        assertNull(defaultPersonFilter.getPersonByDoc("1111111"));
    }


    @Test
    public void getDnaByIdSuccess() {
        assertEquals(defaultPersonFilter.getDnaById(1L).toPrint(), patientDnaData.toPrint());
    }

    @Test
    public void getDnaByIdFail() {
        assertNotNull(defaultPersonFilter.getDnaById(2L));
    }

    @Test
    public void getDnaByCodeSuccess() {
        assertEquals(defaultPersonFilter.getDnaByCode("3D8F825").toPrint(), patientDnaData.toPrint());
    }

    @Test
    public void getDnaByCodeFail() {
        assertNotNull(defaultPersonFilter.getDnaByCode("111111"));
    }

    @Test
    public void getInfectedSuccess() {
        assertFalse(defaultPersonFilter.getInfected().isEmpty());
    }

    @Test
    public void getInfectedFail() {
        assertTrue(defaultPersonFilterEmpty.getInfected().isEmpty());
    }

    @Test
    public void getInfectedByNationalitySuccess() {
        assertFalse(defaultPersonFilter.getInfectedByNationality(CHN).isEmpty());
    }

    @Test
    public void getInfectedByNationalityFail() {
        assertTrue(defaultPersonFilter.getInfectedByNationality(CA).isEmpty());
    }

    @Test
    public void getSuspiciousSuccess() {
        assertFalse(defaultPersonFilter.getSuspicious().isEmpty());
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
        assertFalse(defaultPersonFilter.getSuspiciousByNationality(CHN).isEmpty());
    }

    @Test
    public void getSuspiciousByNationalityFail() {
        assertTrue(defaultPersonFilterEmpty.getSuspiciousByNationality(CHN).isEmpty());
    }

    @Test
    public void getNotInfectedSuccess() {
        assertFalse(defaultPersonFilter.getNotInfected().isEmpty());
    }

    @Test
    public void getNotInfectedFail() {
        assertTrue(defaultPersonFilterEmpty.getNotInfected().isEmpty());
    }

    @Test
    public void getNotInfectedByNationalitySuccess() {
        assertFalse(defaultPersonFilter.getNotInfectedByNationality(BRA).isEmpty());
    }

    @Test
    public void getNotInfectedByNationalityFail() {
        assertTrue(defaultPersonFilterEmpty.getNotInfectedByNationality(BRA).isEmpty());
    }

    @Test
    public void getPatientCombineByBloodSuccess() {
        assertFalse(defaultPersonFilter.getPatientCombineByBlood(A_NEGATIVE).isEmpty());
    }

    @Test
    public void getPatientCombineByBloodFail() {
        assertTrue(defaultPersonFilterEmpty.getPatientCombineByBlood(A_NEGATIVE).isEmpty());
    }

    @Test
    public void getPatientCombineByBloodAndNationalitySuccess() {
        assertFalse(defaultPersonFilter.getPatientCombineByBloodAndNationality(BRA, A_NEGATIVE).isEmpty());
    }

    @Test
    public void getPatientCombineByBloodAndNationalityFail() {
        assertTrue(defaultPersonFilterEmpty.getPatientCombineByBloodAndNationality(BRA, A_NEGATIVE).isEmpty());
    }

    @Test
    public void getPatientAllSuccess() {
        assertFalse(defaultPersonFilter.getPatientAll().isEmpty());
    }

    @Test
    public void getPatientAllFail() {
        assertTrue(defaultPersonFilterEmpty.getPatientAll().isEmpty());
    }
}