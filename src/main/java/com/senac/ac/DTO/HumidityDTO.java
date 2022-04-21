package com.senac.ac.DTO;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class HumidityDTO implements Serializable {
    private static final long serialVersionUID = -8030593407514947625L;

    @NotBlank
    private String humidity;
}
