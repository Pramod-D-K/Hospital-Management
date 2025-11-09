package com.acciojob.first_api_learning;

import com.acciojob.first_api_learning.Entities.Patient;
import com.acciojob.first_api_learning.Services.PatientService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class FirstApiLearningApplicationTests {


    PatientService patientService= new PatientService();

    @Test
    public void maxAge(){
        //create dummy data
        Patient P1=new Patient(1,"",45,"");
        Patient P2=new Patient(2,"",55,"");
        Patient P3=new Patient(3,"",65,"");

        List<Patient> patientList= new ArrayList<>();
        patientList.add(P1);
        patientList.add(P2);
        patientList.add(P3);

        //call the original method and compare

        Patient patient= patientService.getPatientMaxAge(patientList);

        //compare data with expected method output

        Assertions.assertEquals(P3,patient);

    }



}
