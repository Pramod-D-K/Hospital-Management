package com.acciojob.first_api_learning.Services;

import com.acciojob.first_api_learning.Entities.Patient;
import com.acciojob.first_api_learning.Repositories.patientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class patientService {
//    patientRepository patientrepository = new patientRepository();
    @Autowired
    private patientRepository patientrepository;
    public String addToDbViaBody(Patient patient){
        return patientrepository.addToDB(patient);
    }

    public String addToDbViaParam(int id,String name,int age,String disease){
        Patient patient=new Patient(id,name,age,disease);
        return patientrepository.addToDB(patient);
    }
    //List<Patient> patientList=patientrepository.getAllPatient();

    public Patient getFromDbViaParam(Integer id,String name){
        List<Patient> patientList=patientrepository.getAllPatient();

        if(id==null){
            for (Patient patient:patientList){
                if(patient.getName().equals(name)){
                    return patient;
                }
            }
        }
        return patientrepository.getFromDb(id,name);
    }
    public Patient getFromDbViaPath(Integer id){
        List<Patient> patientList=patientrepository.getAllPatient();

        for (Patient patient:patientList){
            if(patient.getId()==id){
                return patient;
            }
        }
        return null;
    }

    public String getOlderFromDb(){
        List<Patient> patientList=patientrepository.getAllPatient();
        int age=-1;
        String name = "";
        for (Patient patient:patientList){
            if(age>patient.getAge()){
                age = patient.getAge();
                name = patient.getName();
            }
        }
        return name;

    }
    public String getYoungerFromDb(){
        List<Patient> patientList=patientrepository.getAllPatient();
        int age=100;
        String name = "";
        for (Patient patient:patientList){
            if(age<patient.getAge()){
                age = patient.getAge();
                name = patient.getName();
            }
        }
        return name;
    }
}
