package com.acciojob.first_api_learning;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RequestMapping("/patient")
public class patientApiClass {

    Map<Integer,Patient> patientDB = new HashMap<>();

    //Using @RequestParam
    @PostMapping("/addViaParam")
    public String addViaParam(@RequestParam("id") int id,
                              @RequestParam("name") String name,
                              @RequestParam("age") int age,
                              @RequestParam("disease") String disease){
        Patient p= new Patient(id,name,age,disease);
        Integer key= id;
        patientDB.put(id,p);
        return "Patient info added via param";
    }
    @GetMapping("/getViaParam")
    public Patient getViaParam(@RequestParam(value = "id", required = false) Integer id,
                               @RequestParam(value = "name", required = false) String name){
        if(name!=null){
            for (Patient patient: patientDB.values()){
                if(patient.getName().equals(name)){
                    return patient;
                }
            }
        }

        Patient p1 = patientDB.get(id);
        return p1;

    }

    //@RequestBody
    @PostMapping("/addViaBody")
    public String addViaBody(@RequestBody Patient patient){

        Integer key = patient.getId();
        patientDB.put(key,patient);
        return "patient add via body";
    }

    //getting through path variable
    @GetMapping("/getViaPath/{id}/")
    public Patient getViaPath(@PathVariable("id") Integer id){
        Patient patient= patientDB.get(id);
        return patient;
    }

    @GetMapping("/findOldest")
    public String findOldest(){
        int age=Integer.MIN_VALUE;
        String name = "";

        for (Patient patient:patientDB.values()){
            if(patient.getAge()>age){
                age = patient.getAge();
                name= patient.getName();
            }
        }
        return name;
    }

    @GetMapping("/findYounger")
    public String findYounger(){
        int age=Integer.MAX_VALUE;
        String name = "";

        for (Patient patient:patientDB.values()){
            if(patient.getAge()<age){
                age = patient.getAge();
                name= patient.getName();
            }
        }
        return name;
    }




}
