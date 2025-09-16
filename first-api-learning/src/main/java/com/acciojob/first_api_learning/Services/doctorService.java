package com.acciojob.first_api_learning.Services;

import com.acciojob.first_api_learning.Entities.Doctor;
import com.acciojob.first_api_learning.Repositories.doctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class doctorService {

    @Autowired
    private doctorRepository doctorrepository;

    public String addStudent(Doctor doctor){
         doctorrepository.save(doctor);
         return "Data is added to doctorDb ";
    }
}
