package com.engsoft2.realstate.controllers;

import com.engsoft2.realstate.entities.User;
import com.engsoft2.realstate.entities.dto.UserDTO;
import com.engsoft2.realstate.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok().body(userService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable int id) {
        return ResponseEntity.ok().body(userService.findById(id));
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok().body(userService.create(userDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> delete(@PathVariable Integer id) {
        userService.delete(id);
        return ResponseEntity.ok(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok().body(userService.update(userDTO));
    }
}
