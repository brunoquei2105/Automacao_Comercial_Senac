package com.senac.ac.service;

import com.senac.ac.DTO.UserDTO;
import com.senac.ac.factory.UserFactory;
import com.senac.ac.models.User;
import com.senac.ac.repository.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;
    private UserFactory userFactory;

    public UserService(UserRepository userRepository, UserFactory userFactory){
        this.userRepository = userRepository;
        this.userFactory = userFactory;
    }

    public List<UserDTO> getAllUsers(){
        return userFactory.toDTO(userRepository.findAll());
    }

    public UserDTO saveUser(User user){
        UserDTO dto = userFactory.setDTO(user);
        userRepository.save(user);
        return dto;
    }

    public Optional<User> getByUserName(String userName) throws UsernameNotFoundException {
        Optional<User> user =Optional.ofNullable( userRepository.findByUserName(userName))
                .orElseThrow(() -> new UsernameNotFoundException("User not Found!"));
        return user;

    }


}
