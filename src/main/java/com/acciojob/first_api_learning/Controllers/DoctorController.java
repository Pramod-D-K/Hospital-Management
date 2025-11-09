package com.acciojob.first_api_learning.Controllers;

import com.acciojob.first_api_learning.Entities.Doctor;
import com.acciojob.first_api_learning.Services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorservice;

    @PostMapping("/add")
    public String add(@RequestBody Doctor doctor){
        return doctorservice.addStudent(doctor);
    }
}
