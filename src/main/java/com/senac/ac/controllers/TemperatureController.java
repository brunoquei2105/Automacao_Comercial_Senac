package com.senac.ac.controllers;

import com.senac.ac.controllers.api.TemperatureApi;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/api")
@Api(value = "Temperature_Api")
public class TemperatureController implements TemperatureApi {
}
