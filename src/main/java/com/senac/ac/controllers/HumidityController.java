package com.senac.ac.controllers;

import com.senac.ac.controllers.api.HumidityApi;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/api")
@Api(value = "Humidity_Api")
public class HumidityController implements HumidityApi {
}
