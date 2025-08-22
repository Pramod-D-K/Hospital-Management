package com.acciojob.first_api_learning;


import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
//@RequestMapping("v2")  //used to add some prefix to the url
public class apiClass {

    Map<Integer,Patient> patientDB = new HashMap<>();

    //Using @RequestParam
    @PostMapping("/addpatientdetails")
    public String addpatientinfo(@RequestParam("id") int id,
                                 @RequestParam("name") String name,
                                 @RequestParam("age") int age,
                                 @RequestParam("disease") String disease){
        Patient p= new Patient(id,name,age,disease);
        int key= id;
        patientDB.put(id,p);
        return "Patient info added";
    }
    @GetMapping("/getpatieninfo")
    public Patient getPatienInfo(@RequestParam("id") Integer id){
        Patient p1 = patientDB.get(id);
        return p1;
    }


    //using @RequestBody
    @PostMapping("/addpatientDBviaRequestBody")
    public String addinfoviaRequestBody(@RequestBody Patient patient){
        Integer key = patient.getId();
        patientDB.put(key,patient);
        return "patient added to db";
    }
    //not possible
    @GetMapping("/getPatientinfoviaRequestBody")
    public Patient getPatientviabody(@RequestBody Patient id){
        Integer key =patientDB.get(id).getId();
        Patient patient= patientDB.get(key);
        return patient;
    }

    @GetMapping("getWeatherInfo")

    public String getWeatherinformation(){
        return "Hi, the temp is 21 degree and wind speed is 20km/hour "+
                " humidity is  30% and feels good ";
    }
    @GetMapping("/getHelloWorld")
    public String getingHelloworld(){
        return "\"Hello World\" ";
    }

    @GetMapping("/sum")
    public String calculateSum(@RequestParam("no1")Integer num1,@RequestParam("no2")Integer num2){
        long total = num1+num2;
        return "The sum of "+num1 + " and "+num2+ " is "+total;
    }
    @GetMapping("/intsum")
    public int intsum(@RequestParam("no1")int num1, @RequestParam("no2") int num2){
        return num1+num2;
    }

}
