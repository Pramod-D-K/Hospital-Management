package com.acciojob.first_api_learning.Controllers;

import com.acciojob.first_api_learning.Entities.Patient;
import com.acciojob.first_api_learning.Services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientservice;
    @PostMapping("/add")
    public  String add(@RequestBody Patient patient){
        return patientservice.add(patient);
    }

}
