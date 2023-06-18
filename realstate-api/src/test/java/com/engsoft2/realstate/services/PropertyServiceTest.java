package com.engsoft2.realstate.services;

import com.engsoft2.realstate.entities.Property;
import com.engsoft2.realstate.entities.User;
import com.engsoft2.realstate.entities.dto.PropertyDTO;
import com.engsoft2.realstate.exceptions.ObjectNotFoundException;
import com.engsoft2.realstate.repositories.PropertyRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class PropertyServiceTest {
    @InjectMocks
    private PropertyService propertyService;

    @Mock
    private PropertyRepository propertyRepository;

    @Mock
    private UserService userService;

    @Before
    public void setup() {
        propertyService = new PropertyService(propertyRepository, userService);
    }

    @Test
    public void testCreate() {
        // Arrange
        PropertyDTO propertyDTO = mockPropertyDTO();
        User user = mockUser();
        Property savedProperty = new Property(1, "Test Property", "Test Description", "image_url", "type", "sale_mode",
                "address", 100.0, "contact_info", 100000.0, 2, 3, 1, true, true, user);

        Mockito.when(userService.findById(propertyDTO.getUserId())).thenReturn(user);
        Mockito.when(propertyRepository.save(Mockito.any(Property.class))).thenReturn(savedProperty);

        // Act
        Property createdProperty = propertyService.create(propertyDTO);

        // Assert
        Assert.assertEquals(savedProperty.getName(), createdProperty.getName());
        Assert.assertEquals(savedProperty.getDescription(), createdProperty.getDescription());
        Assert.assertEquals(savedProperty.getUser(), createdProperty.getUser());
    }

    @Test
    public void testFindById() {
        // Arrange
        int propertyId = 1;
        Property property = new Property(propertyId, "Test Property", "Test Description", "image_url", "type", "sale_mode",
                "address", 100.0, "contact_info", 100000.0, 2, 3, 1, true, true, mockUser());
        Mockito.when(propertyRepository.findById(propertyId)).thenReturn(Optional.of(property));

        // Act
        Property foundProperty = propertyService.findById(propertyId);

        // Assert
        Assert.assertEquals(property, foundProperty);
    }

    @Test(expected = ObjectNotFoundException.class)
    public void testFindByIdNonExistingProperty() {
        // Arrange
        int propertyId = 1;
        Mockito.when(propertyRepository.findById(propertyId)).thenReturn(Optional.empty());

        // Act
        propertyService.findById(propertyId);
    }

    @Test
    public void testFindAll() {
        // Arrange
        List<Property> properties = new ArrayList<>();
        properties.add(new Property(1, "Property 1", "Description 1", "image_url_1", "type", "sale_mode",
                "address", 100.0, "contact_info", 100000.0, 2, 3, 1, true, true, mockUser()));
        properties.add(new Property(2, "Property 2", "Description 2", "image_url_2", "type", "sale_mode",
                "address", 200.0, "contact_info", 200000.0, 3, 4, 2, true, false, mockUser()));
        properties.add(new Property(3, "Property 3", "Description 3", "image_url_3", "type", "sale_mode",
                "address", 300.0, "contact_info", 300000.0, 4, 5, 3, false, false, mockUser()));

        Mockito.when(propertyRepository.findAll()).thenReturn(properties);

        // Act
        List<Property> foundProperties = propertyService.findAll();

        // Assert
        Assert.assertEquals(properties.size(), foundProperties.size());
        Assert.assertEquals(properties.get(0), foundProperties.get(0));
        Assert.assertEquals(properties.get(1), foundProperties.get(1));
        Assert.assertEquals(properties.get(2), foundProperties.get(2));
    }

    @Test
    public void testDelete() {
        // Arrange
        int propertyId = 1;
        Property property = new Property(propertyId, "Test Property", "Test Description", "image_url", "type", "sale_mode",
                "address", 100.0, "contact_info", 100000.0, 2, 3, 1, true, true, mockUser());

        Mockito.when(propertyRepository.findById(propertyId)).thenReturn(Optional.of(property));

        // Act
        propertyService.delete(propertyId);

        // Assert
        Mockito.verify(propertyRepository, Mockito.times(1)).delete(property);
    }

    @Test(expected = ObjectNotFoundException.class)
    public void testDeleteNonExistingProperty() {
        // Arrange
        int propertyId = 1;
        Mockito.when(propertyRepository.findById(propertyId)).thenReturn(Optional.empty());

        // Act
        propertyService.delete(propertyId);
    }

    @Test
    public void testUpdate() {
        // Arrange
        PropertyDTO propertyDTO = mockPropertyDTO();
        User user = mockUser();
        Property existingProperty = new Property(propertyDTO.getId(), "Existing Property", "Existing Description", "existing_image_url",
                "existing_type", "existing_sale_mode", "existing_address", 200.0, "existing_contact_info",
                200000.0, 3, 4, 2, true, true, user);
        Property updatedProperty = new Property(propertyDTO.getId(), propertyDTO.getName(), propertyDTO.getDescription(),
                propertyDTO.getImageUrl(), propertyDTO.getType(), propertyDTO.getSaleMode(), propertyDTO.getAddress(),
                propertyDTO.getSize(), propertyDTO.getContactInfo(), propertyDTO.getPrice(), propertyDTO.getBathroomCount(),
                propertyDTO.getRoomCount(), propertyDTO.getParkingCount(), propertyDTO.isActive(), propertyDTO.isCommercial(), user);

        Mockito.when(propertyRepository.findById(propertyDTO.getId())).thenReturn(Optional.of(existingProperty));
        Mockito.when(propertyRepository.save(Mockito.any(Property.class))).thenReturn(updatedProperty);

        // Act
        Property result = propertyService.update(propertyDTO);

        // Assert
        Assert.assertEquals(updatedProperty.getName(), result.getName());
        Assert.assertEquals(updatedProperty.getDescription(), result.getDescription());
        Assert.assertEquals(updatedProperty.getImageUrl(), result.getImageUrl());
        Assert.assertEquals(updatedProperty.getType(), result.getType());
        Assert.assertEquals(updatedProperty.getSaleMode(), result.getSaleMode());
        Assert.assertEquals(updatedProperty.getAddress(), result.getAddress());
        Assert.assertEquals(updatedProperty.getSize(), result.getSize(), 0.01);
        Assert.assertEquals(updatedProperty.getContactInfo(), result.getContactInfo());
        Assert.assertEquals(updatedProperty.getPrice(), result.getPrice(), 0.01);
        Assert.assertEquals(updatedProperty.getBathroomCount(), result.getBathroomCount());
        Assert.assertEquals(updatedProperty.getRoomCount(), result.getRoomCount());
        Assert.assertEquals(updatedProperty.getParkingCount(), result.getParkingCount());
        Assert.assertEquals(updatedProperty.isActive(), result.isActive());
        Assert.assertEquals(updatedProperty.isCommercial(), result.isCommercial());
        Assert.assertEquals(updatedProperty.getUser(), result.getUser());
    }

    @Test(expected = ObjectNotFoundException.class)
    public void testUpdateNonExistingProperty() {
        // Arrange
        PropertyDTO propertyDTO = mockPropertyDTO();

        Mockito.when(propertyRepository.findById(propertyDTO.getId())).thenReturn(Optional.empty());

        // Act
        propertyService.update(propertyDTO);
    }

    private PropertyDTO mockPropertyDTO() {
        return new PropertyDTO(1, "Test Property", "Test Description", "image_url", "type", "sale_mode", "address",
                100.0, "contact_info", 100000.0, 2, 3, 1, true, true, 1);
    }

    private User mockUser() {
        return new User(1, "Test", "test@test.com", "password", new ArrayList<>());
    }
}