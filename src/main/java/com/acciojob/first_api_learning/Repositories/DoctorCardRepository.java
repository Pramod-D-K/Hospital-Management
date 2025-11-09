package com.acciojob.first_api_learning.Repositories;

import com.acciojob.first_api_learning.Entities.DoctorCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorCardRepository extends JpaRepository<DoctorCard, Integer> {
}
