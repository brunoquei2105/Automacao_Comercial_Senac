package com.senac.ac.factory;

import com.senac.ac.DTO.UserDTO;
import com.senac.ac.models.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserFactory {

    public UserDTO setDTO(User user){
        UserDTO dto = new UserDTO();
        BeanUtils.copyProperties(user, dto);
        return dto;
    }

    public List<UserDTO> toDTO(List<User> users){
        List<UserDTO> dtos = new ArrayList<>();
        users.stream().forEach(e -> dtos.add(setDTO(e)));
        return dtos;
    }
}
