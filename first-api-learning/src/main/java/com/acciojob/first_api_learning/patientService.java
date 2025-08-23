package com.acciojob.first_api_learning;

public class patientService {
    patientRepository patientrepository = new patientRepository();

    public String addToDbViaBody(Patient patient){
        return patientrepository.addToDB(patient);
    }

    public String addToDbViaParam(int id,String name,int age,String disease){
        Patient patient=new Patient(id,name,age,disease);
        return patientrepository.addToDB(patient);
    }
    public Patient getFromDbViaParam(Integer id,String name){
        return patientrepository.getFromDb(id,name);
    }
    public Patient getFromDbViaPath(Integer id){
        return patientrepository.getFromDb(id);
    }
    public String getOlderFromDb(){
        return patientrepository.getOlderPatient();
    }
    public String getYoungerFromDb(){
        return patientrepository.getYoungerPatient();
    }
}
