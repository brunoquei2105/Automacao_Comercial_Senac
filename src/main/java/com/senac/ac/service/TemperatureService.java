package com.senac.ac.service;

import com.senac.ac.DTO.TemperatureDTO;
import com.senac.ac.factory.TemperatureFactory;
import com.senac.ac.models.TemperatureModel;
import com.senac.ac.repository.TemperatureRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemperatureService {

    private TemperatureRepository temperatureRepository;
    private final TemperatureFactory temperatureFactory;

    public TemperatureService(TemperatureRepository temperatureRepository, TemperatureFactory temperatureFactory){
        this.temperatureRepository = temperatureRepository;
        this.temperatureFactory = temperatureFactory;
    }

    public List<TemperatureDTO> getAll(){
        return temperatureFactory.toDTO(temperatureRepository.findAll());
    }

    public TemperatureDTO saveTemp(TemperatureModel model){
        TemperatureDTO dto = temperatureFactory.setDTO(model);
        temperatureRepository.save(model);
        return dto;
    }


}

//Converter String para BigDecimal
// BigDecimal.valueOf(Double.valueOf("123.42"))