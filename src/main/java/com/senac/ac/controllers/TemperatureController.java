package com.senac.ac.controllers;

import com.senac.ac.DTO.TemperatureDTO;
import com.senac.ac.controllers.api.TemperatureApi;
import com.senac.ac.models.TemperatureModel;
import com.senac.ac.service.TemperatureService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("${base.path.uri}")
public class TemperatureController implements TemperatureApi {

    private TemperatureService service;

    public TemperatureController(TemperatureService service){
        this.service = service;
    }

    public ResponseEntity<List<TemperatureDTO>> getAllTemp(){
        List<TemperatureDTO> dto = service.getAll();
        return new ResponseEntity(dto, HttpStatus.OK);
    }

    public ResponseEntity<TemperatureDTO> postTemp(TemperatureModel temperature, HttpHeaders headers){
        TemperatureDTO dto = service.saveTemp(temperature);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
}
