package com.senac.ac.service;

import com.senac.ac.DTO.HumidityDTO;
import com.senac.ac.models.HumidityModel;
import com.senac.ac.repository.HumidityRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HumidityService {

    private HumidityRepository humidityRepository;

    public HumidityService(HumidityRepository humidityRepository){
        this.humidityRepository = humidityRepository;
    }

    public List<HumidityDTO> getAll(){
        return toDTO(humidityRepository.findAll());
    }

    public HumidityDTO saveHumidity(HumidityModel model){
        HumidityDTO dto = setDTO(model);
        humidityRepository.save(model);
        return dto;
    }

    private  List<HumidityDTO> toDTO(List<HumidityModel> models){
        List<HumidityDTO> dtos = new ArrayList<>();
        models.stream().forEach(e -> dtos.add(setDTO(e)));
        return dtos;
    }

    private HumidityDTO setDTO(HumidityModel model){
        HumidityDTO dto = new HumidityDTO();
        dto.setHumidity(String.valueOf(model.getHumidity()));
        dto.setDate_time(String.valueOf(model.getTime()));

        return dto;
    }
}
