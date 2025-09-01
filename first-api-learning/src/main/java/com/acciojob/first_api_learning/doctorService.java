package com.acciojob.first_api_learning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class doctorService {

    //doctorRepository doctorrepository = new doctorRepository();
    @Autowired
    private doctorRepository doctorrepository;
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
            if(doctor.getName().equalsIgnoreCase(name)){
                return doctor;
            }
        }
        return null;
    }
    public String deleteById(Integer id){
        return doctorrepository.deleteById(id);
    }
    public String deleteByIdName(Integer id,String name){
        if(id!=null){
            return doctorrepository.deleteById(id);
        }
        return doctorrepository.deleteByName(name);
    }

    public String clearAllFromDb(){

            return doctorrepository.clearDb();

    }
    public String updateDbIdExp(int id, double exp){
        return doctorrepository.updateDb(id,exp);
    }
    public String updateIdObj(int id, Doctor doctor){
        return doctorrepository.updateDb(id,doctor);
    }
}
