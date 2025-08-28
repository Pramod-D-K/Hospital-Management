package com.acciojob.first_api_learning;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity getViaPath(@PathVariable("id")Integer id){

        Patient patient= patientservice.getFromDbViaPath(id);
        if(patient==null){
            return new ResponseEntity("No valid patient fount",HttpStatus.BAD_REQUEST);
        }
        return  new ResponseEntity(patient, HttpStatus.OK);
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
