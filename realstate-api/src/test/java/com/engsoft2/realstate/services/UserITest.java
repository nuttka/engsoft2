package com.engsoft2.realstate.services;

import com.engsoft2.realstate.entities.User;
import com.engsoft2.realstate.entities.dto.UserDTO;
import com.engsoft2.realstate.repositories.UserRepository;
import com.engsoft2.realstate.utils.JsonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class UserITest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Test
    public void testCreateUser() throws Exception {
        when(userRepository.save(any(User.class))).thenReturn(mockUser());

        ResultActions resultActions = mockMvc.perform(post("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.toJson(mockUserDTO())));

        resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(mockUser().getName())))
                .andExpect(jsonPath("$.email", is(mockUser().getEmail())));

        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    public void testGetUserById() throws Exception {
        int userId = 1;
        User user = mockUser();
        when(userRepository.findById(userId)).thenReturn(java.util.Optional.of(user));

        ResultActions resultActions = mockMvc.perform(get("/user/{id}", userId)
                .contentType(MediaType.APPLICATION_JSON));

        resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(userId)))
                .andExpect(jsonPath("$.name", is(user.getName())))
                .andExpect(jsonPath("$.email", is(user.getEmail())));

        verify(userRepository, times(1)).findById(userId);
    }

    @Test
    public void testGetAllUsers() throws Exception {
        List<User> userList = List.of(
                new User(1, "John Doe", "john.doe@example.com", "password", new ArrayList<>()),
                new User(2, "Jane Smith", "jane.smith@example.com", "password", new ArrayList<>())
        );
        when(userRepository.findAll()).thenReturn(userList);
        ResultActions resultActions = mockMvc.perform(get("/user")
                .contentType(MediaType.APPLICATION_JSON));

        resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name", is(userList.get(0).getName())))
                .andExpect(jsonPath("$[1].name", is(userList.get(1).getName())));

        verify(userRepository, times(1)).findAll();
    }

    @Test
    public void testUpdateUser() throws Exception {
        int userId = 1;
        UserDTO userDTO = new UserDTO(userId, "John Doe", "john.doe@example.com", "newpassword");
        User updatedUser = new User(userId, userDTO.getName(), userDTO.getEmail(), userDTO.getPassword(), new ArrayList<>());
        when(userRepository.findById(userId)).thenReturn(java.util.Optional.of(new User(userId, "Jane Smith", "jane.smith@example.com", "password", new ArrayList<>())));
        when(userRepository.save(any(User.class))).thenReturn(updatedUser);

        ResultActions resultActions = mockMvc.perform(put("/user/{id}", userId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.toJson(userDTO)));

        resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(userId)))
                .andExpect(jsonPath("$.name", is(userDTO.getName())))
                .andExpect(jsonPath("$.email", is(userDTO.getEmail())));

        verify(userRepository, times(1)).findById(userId);
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    public void testDeleteUser() throws Exception {
        int userId = 1;
        when(userRepository.findById(userId)).thenReturn(Optional.of(mockUser()));

        ResultActions resultActions = mockMvc.perform(delete("/user/{id}", userId)
                .contentType(MediaType.APPLICATION_JSON));

        resultActions.andExpect(status().isOk());

        verify(userRepository, times(1)).findById(userId);
        verify(userRepository, times(1)).delete(any(User.class));
    }

    private User mockUser() {
        return new User(1, "Test", "test@test.com", "password", new ArrayList<>());
    }
    private UserDTO mockUserDTO() {
        return new UserDTO(1, "Test", "test@test.com", "password");
    }
}
