package com.senac.ac.controllers;

import com.senac.ac.DTO.UserDTO;
import com.senac.ac.controllers.api.UserApi;
import com.senac.ac.models.User;
import com.senac.ac.service.UserService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("${base.path.uri}")
public class UserController implements UserApi {

    private final UserService userService;
    private final PasswordEncoder encoder;

    public UserController(UserService userService, PasswordEncoder encoder){

        this.userService = userService;
        this.encoder = encoder;
    }

    @Override
    public ResponseEntity<List<UserDTO>> getAllUser(){
        List<UserDTO> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserDTO> postUser(User user,HttpHeaders headers){
        user.setPassword(encoder.encode(user.getPassword()));
        UserDTO dto = userService.saveUser(user);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
    @Override
    public ResponseEntity<Boolean> validatePassword(String userName, String password){

        Optional<User> user = userService.getByUserName(userName);
        if (user.isEmpty()){
            return new ResponseEntity<>(false, HttpStatus.UNAUTHORIZED);
        }

        User optUser = user.get();
        boolean valid = encoder.matches(password, optUser.getPassword());

        HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
        return new ResponseEntity<>(valid, status);
    }
}
