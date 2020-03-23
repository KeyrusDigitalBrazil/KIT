package com.keyrus.kit.filter;

import com.keyrus.kit.builder.PatientBuilder;
import com.keyrus.kit.data.PatientDnaData;
import com.keyrus.kit.filter.impl.DefaultPersonFilter;
import com.keyrus.kit.models.Patient;
import com.keyrus.kit.utils.impl.DefaultMenuUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.keyrus.kit.models.enums.Nationality.*;


public class DefaultPersonFilterTest {

    private DefaultPersonFilter defaultPersonFilter;
    private DefaultPersonFilter defaultPersonFilterEmpty;
    private Patient patient;
    private PatientDnaData patientDnaData;
    private DefaultMenuUtils defaultMenuUtils;

    @Before
    public void setUp(){
        defaultMenuUtils = new DefaultMenuUtils();
        defaultPersonFilter = new DefaultPersonFilter();
        defaultPersonFilterEmpty = new DefaultPersonFilter();
        patient = PatientBuilder.defaultValues();
        defaultPersonFilter.setPatientList(PatientBuilder.patientBuilderList());
        defaultPersonFilterEmpty.setPatientList(PatientBuilder.patientBuilderListEmpty());
        patientDnaData = new PatientDnaData(patient, patient.getDna());
    }

    @Test
    public void getPersonByDocSucess(){
        Assert.assertEquals(defaultPersonFilter.getPersonByDoc("08172367082").toString(), patient.toString());
    }

    @Test
    public void getPersonByDocFail(){
        Assert.assertNull(defaultPersonFilter.getPersonByDoc("1111111"));
    }


    @Test
    public void getDnaByIdSucess(){
        Assert.assertEquals(defaultPersonFilter.getDnaById(1L).toString(),patientDnaData.toString());
    }

    @Test
    public void getDnaByIdFail(){
        Assert.assertNotNull(defaultPersonFilter.getDnaById(2L));
    }

    @Test
    public void getDnaByCodeSucess(){
        Assert.assertEquals(defaultPersonFilter.getDnaByCode("3D8F825").toString(),patientDnaData.toString());
    }

    @Test
    public void getDnaByCodeFail(){
        Assert.assertNotNull(defaultPersonFilter.getDnaByCode("111111"));
    }

    @Test
    public void getInfectedSucess(){
        Assert.assertTrue(defaultPersonFilter.getInfected().size() > 0);
    }

    @Test
    public void getInfectedFail(){
        Assert.assertTrue(defaultPersonFilterEmpty.getInfected().isEmpty());
    }

    @Test
    public void getInfectedByNationalitySucess(){
        Assert.assertTrue(defaultPersonFilter.getInfectedByNationality(CHN).size() > 0);
    }

    @Test
    public void getInfectedByNationalityFail(){
        Assert.assertTrue(defaultPersonFilter.getInfectedByNationality(CA).isEmpty());
    }

    @Test
    public void getSuspiciousSucess(){
        Assert.assertTrue(defaultPersonFilter.getSuspicious().size() > 0);
    }

    @Test
    public void getSuspiciousFail(){
        Assert.assertTrue(defaultPersonFilterEmpty.getSuspicious().isEmpty());
    }

    @Test
    public void cleanStringSucess(){
        Assert.assertEquals("08172367082", defaultPersonFilter.cleanString("081.72..;3.//6\\70-82"));
    }

    @Test
    public void cleanStringFail(){
        Assert.assertNotEquals("08172367082", defaultPersonFilter.cleanString("081.723.670AAAAAA-82"));
    }
}