package com.engsoft2.realstate.services;

import com.engsoft2.realstate.entities.User;
import com.engsoft2.realstate.entities.dto.UserDTO;
import com.engsoft2.realstate.repositories.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;


    @Test
    public void testCreateNome() {
        UserDTO userDTO = mockUserDTO();

        Mockito.when(this.userRepository.save(Mockito.any())).thenReturn(mockUser());
        User userReturn = this.userService.create(userDTO);

        Assert.assertEquals(userDTO.getName(), userReturn.getName());
    }
    @Test
    public void testCreateEmail() {
        UserDTO userDTO = mockUserDTO();

        Mockito.when(this.userRepository.save(Mockito.any())).thenReturn(mockUser());
        User userReturn = this.userService.create(userDTO);

        Assert.assertEquals(userDTO.getEmail(), userReturn.getEmail());
    }
    @Test
    public void testCreateSenha() {
        UserDTO userDTO = mockUserDTO();

        Mockito.when(this.userRepository.save(Mockito.any())).thenReturn(mockUser());
        User userReturn = this.userService.create(userDTO);

        Assert.assertEquals(userDTO.getPassword(), userReturn.getPassword());
    }


    public UserDTO mockUserDTO() {
        return new UserDTO(0, "Test", "teste@teste.com", "senha");
    }

    public User mockUser() {
        return new User(0, "Test", "teste@teste.com", "senha", new ArrayList<>());
    }
}
