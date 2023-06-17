package com.engsoft2.realstate.services;

import com.engsoft2.realstate.entities.User;
import com.engsoft2.realstate.entities.dto.UserDTO;
import com.engsoft2.realstate.exceptions.ObjectNotFoundException;
import com.engsoft2.realstate.repositories.UserRepository;
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
public class UserServiceTest {
    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    private User existingUser;

    @Before
    public void setUp() {
        existingUser = mockUser();
    }

    @Test
    public void testCreate() {
        UserDTO userDTO = mockUserDTO();
        User savedUser = mockUser();

        Mockito.when(userRepository.save(Mockito.any(User.class))).thenReturn(savedUser);

        User createdUser = userService.create(userDTO);

        Assert.assertEquals(userDTO.getName(), createdUser.getName());
        Assert.assertEquals(userDTO.getEmail(), createdUser.getEmail());
        Assert.assertEquals(userDTO.getPassword(), createdUser.getPassword());
    }

    @Test
    public void testFindById() {
        int userId = 1;
        Mockito.when(userRepository.findById(userId)).thenReturn(Optional.of(existingUser));

        User foundUser = userService.findById(userId);

        Assert.assertEquals(existingUser, foundUser);
    }

    @Test(expected = ObjectNotFoundException.class)
    public void testFindByIdInvalid() {
        int userId = 1;
        Mockito.when(userRepository.findById(userId)).thenReturn(Optional.empty());

        userService.findById(userId);
    }

    @Test
    public void testFindAll() {
        List<User> userList = new ArrayList<>();
        userList.add(existingUser);
        Mockito.when(userRepository.findAll()).thenReturn(userList);
        List<User> foundUsers = userService.findAll();

        Assert.assertEquals(userList, foundUsers);
    }

    @Test
    public void testDelete() {
        int userId = 1;
        Mockito.when(userRepository.findById(userId)).thenReturn(Optional.of(existingUser));

        userService.delete(userId);
        Mockito.verify(userRepository, Mockito.times(1)).delete(existingUser);
    }

    @Test(expected = ObjectNotFoundException.class)
    public void testDelete_InvalidId() {
        int userId = 1;
        Mockito.when(userRepository.findById(userId)).thenReturn(Optional.empty());

        userService.delete(userId);
    }

    @Test
    public void testUpdate() {
        UserDTO userDTO = mockUserDTO();
        User updatedUser = mockUser();
        Mockito.when(userRepository.findById(userDTO.getId())).thenReturn(Optional.of(existingUser));
        Mockito.when(userRepository.save(Mockito.any(User.class))).thenReturn(updatedUser);

        User result = userService.update(userDTO);

        Assert.assertEquals(updatedUser, result);
    }

    @Test(expected = ObjectNotFoundException.class)
    public void testUpdateInvalid() {
        UserDTO userDTO = mockUserDTO();
        Mockito.when(userRepository.findById(userDTO.getId())).thenReturn(Optional.empty());

        userService.update(userDTO);
    }

    private UserDTO mockUserDTO() {
        return new UserDTO(1, "Test", "test@test.com", "password");
    }

    private User mockUser() {
        return new User(1, "Test", "test@test.com", "password", new ArrayList<>());
    }
}
