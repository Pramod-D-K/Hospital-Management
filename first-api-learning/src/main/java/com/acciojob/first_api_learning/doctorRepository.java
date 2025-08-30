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

    public String deleteById(Integer id){
        for (Doctor doctor:doctorDb.values()){
            if(doctor.getId()==id){
                return "Doctor  "+doctor.getName()+" deleted from Db";
            }
        }
        return "Doctor with id "+id+" not found";
    }
    public  String deleteByName(String name){
        Doctor doctor=null;
        for (Doctor temp:doctorDb.values()){
            if(temp.getName().equalsIgnoreCase(name)){
                doctor=temp;
                break;
            }
        }
        if(doctor!=null){
            doctorDb.values().remove(doctor);
            return  "Doctor with name "+ name+ "has been deleted from Db";
        }
        return "Doctor with name "+name+" not found";
    }
    private String Password = "Pramod123";



    public String clearDb(){
        doctorDb.clear();
        return "Data base cleared";
    }

    public String updateDb(int id , double exp) {
        Doctor doctor=null;
        for (Doctor temp : doctorDb.values()){
            if(temp.getId()==id){
                doctor = temp;
            }
        }
        if(doctor==null)return "Doctor with  " +id+ "not found in Db";
        doctor.setExp(exp);
        return  "Doctor "+doctor.getName()+" experience updated";
    }

    public String updateDb(int id, Doctor d){
        if (!doctorDb.containsKey(id)) {
            return "Doctor with " + id + " not found in Db";
        }

        doctorDb.put(id, d); // replaces the old doctor with new one
        return "Doctor " + d.getName() + " updated successfully";
    }

}

