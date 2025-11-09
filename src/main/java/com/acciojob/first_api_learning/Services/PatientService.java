package com.acciojob.first_api_learning.Services;

import com.acciojob.first_api_learning.Entities.Patient;
import com.acciojob.first_api_learning.Repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientrepository;

    public String add (Patient patient){
        patientrepository.save(patient);
        return "Data added to patientDb";
    }

    /// to write code for test

    public Patient getPatientMaxAge(List<Patient> patientList){
        int patientAge=0;
        Patient p=null;
        for (Patient patient:patientList){
            if(patient.getAge()>patientAge){
                patientAge=patient.getAge();
                p=patient;
            }
        }
        return p;
    }
}
