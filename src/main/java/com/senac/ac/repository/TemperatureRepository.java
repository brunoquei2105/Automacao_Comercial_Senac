package com.senac.ac.repository;

import com.senac.ac.models.TemperatureModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  TemperatureRepository extends JpaRepository<TemperatureModel, Long> {
}
