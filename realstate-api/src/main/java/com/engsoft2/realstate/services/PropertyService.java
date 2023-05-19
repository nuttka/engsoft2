package com.engsoft2.realstate.services;

import com.engsoft2.realstate.entities.Property;
import com.engsoft2.realstate.entities.User;
import com.engsoft2.realstate.entities.dto.PropertyDTO;
import com.engsoft2.realstate.entities.dto.UserDTO;
import com.engsoft2.realstate.exceptions.ObjectNotFoundException;
import com.engsoft2.realstate.repositories.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService {
    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private UserService userService;

    public PropertyService(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    public Property create(PropertyDTO propertyDTO) {
        Property newProperty = propertyDTO.toProperty();
        User user = userService.findById(propertyDTO.getUserId());

        newProperty.setUser(user);
        return propertyRepository.save(newProperty);
    }

    public Property findById(int id) {
        return propertyRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Property not found. Id: " + id));
    }

    public List<Property> findAll() {
        return propertyRepository.findAll();
    }

    public void delete(int id) {
        Property property = this.findById(id);
        propertyRepository.delete(property);
    }

    public Property update(PropertyDTO propertyDTO) {
        if (this.findById(propertyDTO.getId()) != null)
            return propertyRepository.save(propertyDTO.toProperty());
        return null;
    }
}
