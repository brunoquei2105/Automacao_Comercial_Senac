package com.senac.ac.service;

import com.senac.ac.repository.TemperatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemperatureService {

    @Autowired
    private TemperatureRepository temperatureRepository;
}

//Converter String para BigDecimal
// BigDecimal.valueOf(Double.valueOf("123.42"))