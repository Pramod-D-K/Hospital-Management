package com.acciojob.first_api_learning;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
public class patientController {

    patientService patientservice=new patientService();

    @PostMapping("/addViaBody")
    public String addViaBody(@RequestBody Patient patient){
        String ans = patientservice.addToDbViaBody(patient);
        return ans;
    }

    @PostMapping("/addViaParam")
    public String addViaParam(@RequestParam("id") int id,
                             @RequestParam("name") String name,
                             @RequestParam("age") int age,
                             @RequestParam("disease") String disease){
        return patientservice.addToDbViaParam(id,name,age,disease);
    }

    @GetMapping("/getViaParam")
    public Patient getViaParam(@RequestParam(value = "id",required = false) Integer id,
                               @RequestParam(value = "name", required = false)String name){
        return patientservice.getFromDbViaParam(id,name);
    }

    @GetMapping("/getViaPath/{id}/")
    public Patient getViaPath(@PathVariable("id")Integer id){
        return patientservice.getFromDbViaPath(id);
    }

    @GetMapping("/getOlder")
    public String getOlder(){
        return patientservice.getOlderFromDb();
    }
    @GetMapping("/getYounger")
    public String getYounger(){
        return patientservice.getYoungerFromDb();
    }
}
