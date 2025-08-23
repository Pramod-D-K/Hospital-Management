package com.acciojob.first_api_learning;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/doctor")
public class doctorApiClass {

    Map<Integer,Doctor> doctorDB = new HashMap<>();

    @PostMapping("/addViaParam")
    public String addViaParam(@RequestParam("id") Integer id,
                              @RequestParam("name") String name,
                              @RequestParam("specialist") String specialist,
                              @RequestParam("experience") double experience
                              ){

        Doctor doctor = new Doctor(id,name,specialist,experience);
        doctorDB.put(id,doctor);

        return "Doctor info added via param";

    }
    @PostMapping("/addViabody")
    public String addViaBody (@RequestBody Doctor doctor){
        Integer key = doctor.getId();
        doctorDB.put(key, doctor);
        return "doctor added via body";
    }
    @GetMapping("/getViaParam")
    public Doctor getViaParam(@RequestParam(value = "id", required = true) Integer id,
                              @RequestParam(value = "name", required = false) String name){
        if(name!=null){
            for (Doctor doctor: doctorDB.values()){
                if(doctor.getName().equals(name)){
                    return doctor;
                }
            }
        }
        Doctor doctor= doctorDB.get(id);
        return doctor;
    }

    @GetMapping("/getViaPath/{id}/{name}/")
    public Doctor getViaPath(@PathVariable("id") Integer id,
                             @PathVariable("name") String name){
        Doctor doctor=doctorDB.get(id);
        return doctor;
    }




}
