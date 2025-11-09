package com.acciojob.first_api_learning.Services;

import com.acciojob.first_api_learning.Entities.Doctor;
import com.acciojob.first_api_learning.Repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorrepository;

    public String addStudent(Doctor doctor){
         doctorrepository.save(doctor);
         return "Data is added to doctorDb ";
    }

}
