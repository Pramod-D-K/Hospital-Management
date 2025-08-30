package com.acciojob.first_api_learning;

import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class doctorService {

    doctorRepository doctorrepository = new doctorRepository();
    public String addToDbViaPAram(int id, String name,String spc,double exp){
        Doctor doctor=new Doctor(id,name,spc,exp);
        return doctorrepository.addToDb(doctor);
    }

    public String addToDbViaBody(Doctor doctor){

        return doctorrepository.addToDb(doctor);
    }

    public Doctor getViaIdName(Integer id, String name){
        if (id==null) {
            return getDoctorByName(name);
        }
        return getDoctorFromDb(id);
    }

    public Doctor getDoctorFromDb(Integer id){
        List<Doctor>doctorList= doctorrepository.allDoctors();
        for (Doctor doctor: doctorList){
            if(doctor.getId()==id){
                return doctor;
            }
        }
        return null;
    }
    public Doctor getDoctorByName(String name){
        List<Doctor>doctorList= doctorrepository.allDoctors();
        for(Doctor doctor:doctorList){
            if(doctor.getName().equals(name)){
                return doctor;
            }
        }
        return null;
    }
}
