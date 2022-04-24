package com.senac.ac.service;

import com.senac.ac.DTO.TemperatureDTO;
import com.senac.ac.models.TemperatureModel;
import com.senac.ac.repository.TemperatureRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TemperatureService {

    private TemperatureRepository temperatureRepository;

    public TemperatureService(TemperatureRepository temperatureRepository){
        this.temperatureRepository = temperatureRepository;
    }

    public List<TemperatureDTO> getAll(){
         return toDTO(temperatureRepository.findAll());
    }

    public TemperatureDTO saveTemp(TemperatureModel model){
        TemperatureDTO dto = setDTO(model);
        temperatureRepository.save(model);
        return dto;
    }

    private List<TemperatureDTO> toDTO(List<TemperatureModel> model){
        List<TemperatureDTO> dtos = new ArrayList<>();
       model.stream().forEach(e -> dtos.add(setDTO(e)));
        return dtos;

    }

    private TemperatureDTO setDTO(TemperatureModel model){
        TemperatureDTO dto = new TemperatureDTO();
        dto.setTemp(String.valueOf(model.getTemp()));
        dto.setDate_time(String.valueOf(model.getTime()));
        return dto;
    }
}

//Converter String para BigDecimal
// BigDecimal.valueOf(Double.valueOf("123.42"))