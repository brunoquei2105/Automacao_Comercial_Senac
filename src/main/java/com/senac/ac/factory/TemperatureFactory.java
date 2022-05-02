package com.senac.ac.factory;

import com.senac.ac.DTO.TemperatureDTO;
import com.senac.ac.models.TemperatureModel;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class TemperatureFactory {

   public List<TemperatureDTO> toDTO(List<TemperatureModel> model){
        List<TemperatureDTO> dtos = new ArrayList<>();
        model.stream().forEach(e -> dtos.add(setDTO(e)));
        return dtos;

    }

   public TemperatureDTO setDTO(TemperatureModel model){
        TemperatureDTO dto = new TemperatureDTO();
        dto.setTemp(String.valueOf(model.getTemp()));
        dto.setDate_time(String.valueOf(model.getTime()));
        return dto;
    }
}
