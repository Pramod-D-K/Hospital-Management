package com.acciojob.first_api_learning;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/patient")
public class patientApiClass {

    Map<Integer,Patient> patientDB = new HashMap<>();

    //Using @RequestParam
    @PostMapping("/addviaparam")
    public String addviaparam(@RequestParam("id") int id,
                              @RequestParam("name") String name,
                              @RequestParam("age") int age,
                              @RequestParam("disease") String disease){
        Patient p= new Patient(id,name,age,disease);
        int key= id;
        patientDB.put(id,p);
        return "Patient info added via param";
    }
    @GetMapping("/getviaparam")
    public Patient getviaparam(@RequestParam("id") Integer id){
        Patient p1 = patientDB.get(id);
        return p1;
    }

    //@RequestBody
    @PostMapping("/addviabody")
    public String addviabody(@RequestBody Patient patient){

        Integer key = patient.getId();
        patientDB.put(key,patient);
        return "patient add via body";
    }
}
