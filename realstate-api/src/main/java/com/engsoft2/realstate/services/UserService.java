package com.engsoft2.realstate.services;

import com.engsoft2.realstate.entities.User;
import com.engsoft2.realstate.entities.dto.UserDTO;
import com.engsoft2.realstate.exceptions.ObjectNotFoundException;
import com.engsoft2.realstate.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(UserDTO userDTO) {
        User newUser = userDTO.toUser();
        newUser = userRepository.save(newUser);
        return newUser;
    }

    public User findById(int id) {
        return userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("User not found. Id: " + id));
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void delete(int id) {
        User user = this.findById(id);
        userRepository.delete(user);
    }

    public User update(UserDTO userDTO) {
        if (this.findById(userDTO.getId()) != null)
            return userRepository.save(userDTO.toUser());
        return null;
    }
}
