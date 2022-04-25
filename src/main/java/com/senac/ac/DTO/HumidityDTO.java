package com.senac.ac.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class HumidityDTO implements Serializable {
    private static final long serialVersionUID = -8030593407514947625L;

    @NotBlank
    private String humidity;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT-3")
    private String date_time;
}
