package com.acciojob.first_api_learning.Controllers;

import com.acciojob.first_api_learning.Repositories.DoctorCardRepository;
import com.acciojob.first_api_learning.Services.DoctorCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctorcard")
public class DoctorCordController {

    @Autowired
    private DoctorCardService doctorCardService;
    @PostMapping("/generatecard")
    public ResponseEntity generateCard(){
        String res= doctorCardService.generateCard();
        return new ResponseEntity(res, HttpStatus.OK);
    }

    @PutMapping("/associateDoctorAndDoctorCard")
    public ResponseEntity associateDoctorAndDoctorCard(@RequestParam("id")Integer id){
        String res= doctorCardService.associateDoctorAndDoctorCard(id);
        return new ResponseEntity(res,HttpStatus.OK);
    }
}
