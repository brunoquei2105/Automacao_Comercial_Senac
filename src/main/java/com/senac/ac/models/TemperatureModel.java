package com.senac.ac.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tb_temperature")
public class TemperatureModel implements Serializable {
    private static final long serialVersionUID = -1574696334494862387L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "temperature")
    private BigDecimal temp;
    @Column(name = "date_hour")
    private LocalDateTime time;


}
