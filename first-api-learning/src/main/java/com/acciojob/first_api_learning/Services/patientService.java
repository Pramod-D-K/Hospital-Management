package com.acciojob.first_api_learning.Services;

import com.acciojob.first_api_learning.Entities.Patient;
import com.acciojob.first_api_learning.Repositories.patientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class patientService {
    @Autowired
    private patientRepository patientrepository;

    public String add (Patient patient){
        patientrepository.save(patient);
        return "Data added to patientDb";
    }


}
