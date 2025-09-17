package com.acciojob.first_api_learning.Repositories;

import com.acciojob.first_api_learning.Entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public interface doctorRepository extends JpaRepository<Doctor, Integer> {
}

