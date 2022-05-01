package com.senac.ac.controllers.api;

import com.senac.ac.DTO.HumidityDTO;
import com.senac.ac.models.HumidityModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
@Validated
@Api(value = "Humidity_Api")
public interface HumidityApi {

    @ApiOperation(value = "", nickname = "Humidities", notes = "", response = HumidityDTO.class, tags = {})
    @GetMapping(value = "/all/humidity")
    @ResponseStatus(value = HttpStatus.OK)
    default ResponseEntity<List<HumidityDTO>> getAllHumidity(){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @ApiOperation(value = "", nickname = "Humidity", notes = "", response = HumidityDTO.class, tags = {})
    @PostMapping(value = "save/humidity")
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(value = HttpStatus.CREATED)
    default ResponseEntity<HumidityDTO> postHumidity(@RequestBody HumidityModel request,
                                                     @RequestHeader HttpHeaders headers){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
