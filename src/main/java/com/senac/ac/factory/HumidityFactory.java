package com.senac.ac.factory;

import com.senac.ac.DTO.HumidityDTO;
import com.senac.ac.models.HumidityModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HumidityFactory {

    public List<HumidityDTO> toDTO(List<HumidityModel> models){
        List<HumidityDTO> dtos = new ArrayList<>();
        models.stream().forEach(e -> dtos.add(setDTO(e)));
        return dtos;
    }

    public HumidityDTO setDTO(HumidityModel model){
        HumidityDTO dto = new HumidityDTO();
        dto.setHumidity(String.valueOf(model.getHumidity()));
        dto.setDate_time(String.valueOf(model.getTime()));

        return dto;
    }
}
