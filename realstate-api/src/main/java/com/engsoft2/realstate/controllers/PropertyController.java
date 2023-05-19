package com.engsoft2.realstate.controllers;

import com.engsoft2.realstate.entities.Property;
import com.engsoft2.realstate.entities.dto.PropertyDTO;
import com.engsoft2.realstate.services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/property")
public class PropertyController {
    @Autowired
    PropertyService propertyService;

    @GetMapping
    public ResponseEntity<List<Property>> findAll() {
        return ResponseEntity.ok().body(propertyService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Property> findById(@PathVariable int id) {
        return ResponseEntity.ok().body(propertyService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Property> create(@RequestBody PropertyDTO propertyDTO) {
        return ResponseEntity.ok().body(propertyService.create(propertyDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> delete(@PathVariable Integer id) {
        propertyService.delete(id);
        return ResponseEntity.ok(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Property> update(@RequestBody PropertyDTO propertyDTO) {
        return ResponseEntity.ok().body(propertyService.update(propertyDTO));
    }
}
