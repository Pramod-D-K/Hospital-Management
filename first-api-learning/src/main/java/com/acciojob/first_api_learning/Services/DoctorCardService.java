package com.acciojob.first_api_learning.Services;

import com.acciojob.first_api_learning.DoctorCardStatus;
import com.acciojob.first_api_learning.Entities.Doctor;
import com.acciojob.first_api_learning.Entities.DoctorCard;
import com.acciojob.first_api_learning.Repositories.DoctorCardRepository;
import com.acciojob.first_api_learning.Repositories.doctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DoctorCardService {
    @Autowired
    private DoctorCardRepository doctorCardRepository;
    @Autowired
    private doctorRepository doctorRepository;
    public  String generateCard(){
        DoctorCard card = new DoctorCard();
//        LocalDate issueDate =LocalDate.of(2025,01,01);
//        LocalDate expiryDate =LocalDate.of(2027,01,01);
//        card.setIssueDate(issueDate);
//        card.setExpiryDate(expiryDate);
        card.setDoctorCardStatus(DoctorCardStatus.ACTIVE);
        doctorCardRepository.save(card);
        return "Card with cardId "+ card.getCardId()+" has been Added";
    }

    public String associateDoctorAndDoctorCard(Integer id){
        DoctorCard card= doctorCardRepository.findById(id).get();
        Doctor doctor= doctorRepository.findById(id).get();
        LocalDate issueDate =LocalDate.of(2025,01,01);
        LocalDate expiryDate =LocalDate.of(2027,01,01);
        card.setIssueDate(issueDate);
        card.setExpiryDate(expiryDate);
        card .setDoctor(doctor);
        doctorCardRepository.save(card);
        return "Card "+card.getCardId()+" Issued to Doctor "+doctor.getName();

    }
}
