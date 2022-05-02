package com.senac.ac.service;

import com.senac.ac.DTO.HumidityDTO;
import com.senac.ac.factory.HumidityFactory;
import com.senac.ac.models.HumidityModel;
import com.senac.ac.repository.HumidityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HumidityService {

    private HumidityRepository humidityRepository;
    private HumidityFactory humidityFactory;

    public HumidityService(HumidityRepository humidityRepository, HumidityFactory humidityFactory){
        this.humidityRepository = humidityRepository;
        this.humidityFactory = humidityFactory;
    }

    public List<HumidityDTO> getAll(){
        return humidityFactory.toDTO(humidityRepository.findAll());
    }

    public HumidityDTO saveHumidity(HumidityModel model){
        HumidityDTO dto = humidityFactory.setDTO(model);
        humidityRepository.save(model);
        return dto;
    }

}
