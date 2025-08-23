package com.acciojob.first_api_learning;

import java.util.HashMap;
import java.util.Map;

public class patientRepository {
    Map<Integer, Patient> patientDB=new HashMap();
    public String addToDB(Patient patient){
        Integer key =patient.getId();
        patientDB.put(key,patient);
        return "Data to patient DB added";
    }

    public Patient getFromDb(Integer id, String name){
        if(id== null){
            for (Patient patient:patientDB.values()){
                if(patient.getName().equals(name)){
                    return patient;
                }
            }
        }
        Integer key =id;
        return patientDB.get(key);
    }

    public Patient getFromDb(Integer id){
        return patientDB.get(id);
    }

    public String getOlderPatient(){
        int age = 0;
        String name = "";
        for (Patient patient: patientDB.values()){
            if(patient.getAge()>age){
                age = patient.getAge();
                name = patient.getName();
            }
        }
        return name;
    }
    public String getYoungerPatient(){
        int age=Integer.MAX_VALUE;
        String name= "";
        for (Patient patient:patientDB.values()){
            if(patient.getAge()<age){
                age = patient.getAge();
                name= patient.getName();
            }
        }
        return name;
    }

}
