package com.acciojob.first_api_learning;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class patientRepository {
    Map<Integer, Patient> patientDB=new HashMap();
    public String addToDB(Patient patient){
        Integer key =patient.getId();
        patientDB.put(key,patient);
        return "Data to patient DB added";
    }

    public Patient getFromDb(Integer id, String name){
        Integer key =id;
        return patientDB.get(key);
    }

//    public Patient getFromDb(Integer id){
//        return patientDB.get(id);
//    }

    public List<Patient> getAllPatient(){
        //short form
        //return patientDB.values().stream().toList();

        //long form
        List<Patient>patientList = new ArrayList<>();
        for (Patient patient:patientDB.values()){
            patientList.add(patient);
        }
        return patientList;
    }


}
