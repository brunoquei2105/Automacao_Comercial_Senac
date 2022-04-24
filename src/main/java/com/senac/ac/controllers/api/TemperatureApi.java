package com.senac.ac.controllers.api;

import com.senac.ac.DTO.TemperatureDTO;
import com.senac.ac.models.TemperatureModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
@Validated
@Api(value = "Temperature_Api")
public interface TemperatureApi {

    @ApiOperation(value = "", nickname = "Temperatures", notes = "", response = TemperatureDTO.class, tags = {})
    @GetMapping(value = "/all/temperatures")
    @ResponseStatus(value = HttpStatus.OK)
    default ResponseEntity<List<TemperatureDTO>> getAllTemp(){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @ApiOperation(value = "", nickname = "Create Temperature", notes = "", response = TemperatureModel.class, tags = {})
    @PostMapping(value = "/save/temperature")
    @ResponseStatus(value = HttpStatus.CREATED)
    default ResponseEntity<TemperatureDTO> postTemp(@RequestBody TemperatureModel temperature,
                                                 @RequestHeader HttpHeaders headers){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
