package com.acciojob.first_api_learning;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
public class doctorController {
    doctorService doctorservice = new doctorService();


    @PostMapping("/addViaParam")
    public ResponseEntity addViaParam(@RequestParam("id") int id,
                                      @RequestParam("name") String name,
                                      @RequestParam("spc") String spc,
                                      @RequestParam("exp") double exp
                                      ){
        if(id<=0|| name == null || spc == null){
            return new ResponseEntity("data requered", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(doctorservice.addToDbViaPAram(id,name,spc,exp), HttpStatus.OK);
    }
    @PostMapping("/addViaBody")
    public ResponseEntity addViaBody(@RequestBody Doctor doctor){
        return new ResponseEntity(doctorservice.addToDbViaBody(doctor),HttpStatus.OK);
    }

    @GetMapping("/getViaParam")
    public ResponseEntity getViaParam(@RequestParam("id") int id){

        Doctor doctor =doctorservice.getDoctorFromDb(id);
                if(doctor==null){
                    return new ResponseEntity("Doctor not present in Db",HttpStatus.BAD_REQUEST);
                }
        return new ResponseEntity(doctor,HttpStatus.OK);
    }
    @GetMapping("/getViaPath/{id}")
    public ResponseEntity getViaPath(@PathVariable("id")int id){
        Doctor doctor =doctorservice.getDoctorFromDb(id);
        if(doctor!=null){
            return new ResponseEntity(doctor,HttpStatus.OK);
        }
        return new ResponseEntity("Doctor not present in Db",HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getViaParamIdName")
    public ResponseEntity getViaParam(@RequestParam(value = "id",required = false)Integer id,
                                      @RequestParam(value = "name", required = false)String name){
        Doctor doctor= doctorservice.getViaIdName(id,name);
        if(doctor!=null){
            return new ResponseEntity(doctor,HttpStatus.OK);
        }
        return  new ResponseEntity("Doctor not present in Db",HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("deleteViaParamIdName")
    public ResponseEntity deleteViaId(@RequestParam(value = "id",required = false)Integer id,
                                      @RequestParam(value = "name", required = false)String name){
        return new ResponseEntity(doctorservice.deleteByIdName(id,name),HttpStatus.OK);

    }

    @DeleteMapping("/deleteViaPath/{id}")
    public ResponseEntity deleteViaPath(@PathVariable("id")Integer id){

        return new ResponseEntity(doctorservice.deleteById(id),HttpStatus.OK);
    }

    @DeleteMapping("clear")
    public ResponseEntity clearAll(){
        return new ResponseEntity(doctorservice.clearAllFromDb(),HttpStatus.OK);
    }

    @PatchMapping("/updateViaPatch/{id}")
    public String updateViaPatch(@PathVariable int id,
                                 @RequestParam double exp){
        return doctorservice.updateDbIdExp(id,exp);
    }

    @PutMapping("/updateViaPatchBody")
    public ResponseEntity updateViaPatchBody(int id,Doctor doctor){
        return new ResponseEntity(doctorservice.updateIdObj(id,doctor),HttpStatus.OK);
    }
}
