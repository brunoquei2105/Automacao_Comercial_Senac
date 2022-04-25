package com.senac.ac.controllers;

import com.senac.ac.DTO.HumidityDTO;
import com.senac.ac.controllers.api.HumidityApi;
import com.senac.ac.models.HumidityModel;
import com.senac.ac.service.HumidityService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("${base.path.uri}")
public class HumidityController implements HumidityApi {

    private HumidityService humidityService;

    public HumidityController(HumidityService humidityService){
        this.humidityService = humidityService;
    }

    public ResponseEntity<List<HumidityDTO>> getAllHumidity(){
        List<HumidityDTO> dto = humidityService.getAll();
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    public ResponseEntity<HumidityDTO> postHumidity(HumidityModel request, HttpHeaders headers){
        HumidityDTO dto = humidityService.saveHumidity(request);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }


}
