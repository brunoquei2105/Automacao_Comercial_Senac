package com.senac.ac.repository;

import com.senac.ac.models.HumidityModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HumidityRepository extends JpaRepository<HumidityModel, Long> {
}
