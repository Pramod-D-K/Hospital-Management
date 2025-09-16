package com.acciojob.first_api_learning.Controllers;

import com.acciojob.first_api_learning.Entities.Patient;
import com.acciojob.first_api_learning.Services.patientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
public class patientController {

    @Autowired
    private patientService patientservice;
    @PostMapping("/add")
    public  String add(@RequestBody Patient patient){
        return patientservice.add(patient);
    }
    @GetMapping("/get")
    public Patient get(@RequestParam(value = "Id",required = false)int id,
                       @RequestParam(value = "name",required = false)String name){

        return " ";
    }
}
