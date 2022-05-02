package com.senac.ac.controllers.api;

import com.senac.ac.DTO.UserDTO;
import com.senac.ac.models.User;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;
import java.util.List;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
@Validated
@Api(value = "User_Api")
public interface UserApi {

    @ApiOperation(value = "", nickname = "Users", notes = "", response = UserDTO.class, tags = {})
    @GetMapping(value = "/all/users")
    @ResponseStatus(value = HttpStatus.OK)
   default ResponseEntity<List<UserDTO>> getAllUser(){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @ApiOperation(value = "", notes = "", nickname = "User", response = UserDTO.class, tags = {})
    @PostMapping(value = "/save/user")
    @ResponseStatus(value = HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    default ResponseEntity<UserDTO> postUser(@Valid @RequestBody User user, @RequestHeader HttpHeaders headers){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @ApiOperation(value = "", notes = "", nickname = "Validate User", response = Boolean.class, tags = {})
    @GetMapping(value = "/validate/user")
    @ResponseStatus(value = HttpStatus.OK)
    default ResponseEntity<Boolean> validatePassword(@RequestParam String userName, @RequestParam String password){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
