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

    @GetMapping("/getViaParam")
    public Doctor getViaParam(@RequestParam("id") Integer id){
        Doctor doctor= doctorDB.get(id);
        return doctor;
    }

    @PostMapping("/addViabody")
    public String addViaBody (@RequestBody Doctor doctor){
        Integer key = doctor.getId();
        doctorDB.put(key, doctor);
        return "doctor added via body";
    }





}
