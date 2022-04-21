package com.senac.ac.DTO;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class TemperatureDTO {

    @NotBlank
    private String temp;
    private String date_time;
}
