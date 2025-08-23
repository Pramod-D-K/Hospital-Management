package com.acciojob.first_api_learning;


import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(".patient")  //used to add some prefix to the url
public class apiClass {

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
