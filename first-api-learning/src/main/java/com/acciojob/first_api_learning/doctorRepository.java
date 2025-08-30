package com.acciojob.first_api_learning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class doctorRepository {
    Map<Integer,Doctor> doctorDb = new HashMap<>();

    public String addToDb(Doctor doctor){
        Integer key = doctor.getId();
        doctorDb.put(key,doctor);
        return "doctor info added to DB";
    }

    List<Doctor> listOfDoctor = new ArrayList<>();
    public List<Doctor> allDoctors (){

        for (Doctor doctor: doctorDb.values()){
            listOfDoctor.add(doctor);
        }
        return listOfDoctor;
    }
}
