package com.socialmedia.test;

import com.socialmedia.test.dto.UserDto;
import com.socialmedia.test.entities.UserDb;
import com.socialmedia.test.repository.UserRepository;
import com.socialmedia.test.implementation.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserImplTest {

    @InjectMocks
    private UserServiceImpl userServiceImpl;

    @Mock
    private UserRepository userRepository;

    @Mock
    private ModelMapper modelMapper;

    @Test
    void testGetUsers() {
        UserDb userDb = new UserDb();
        userDb.setName("Test User");

        UserDto userDto = new UserDto();
        userDto.setName("Test User");

        when(userRepository.findAll()).thenReturn(Collections.singletonList(userDb));
        when(modelMapper.map(userDb, UserDto.class)).thenReturn(userDto);

        List<UserDto> users = userServiceImpl.getUsers();
        assertFalse(users.isEmpty(), "Users list should not be empty");
        assertTrue(users.stream().anyMatch(user -> user.getName().equals("Test User")), "Test User should be in the users list");
    }

    @Test
    void addUser() {
        UserDto userDto = new UserDto();
        userDto.setName("Test UserDTO");
        userDto.setPhone("9874563215");

        UserDb userDb = new UserDb();
        userDb.setName("Test User");

        doReturn(userDb).when(modelMapper).map(userDto, UserDb.class);
        doReturn(userDto).when(modelMapper).map(userDb, UserDto.class);

        when(userRepository.save(userDb)).thenReturn(userDb);
        UserDto savedUser = userServiceImpl.addUser(userDto);

        Assertions.assertNotNull(savedUser, "User should not be null");
        Assertions.assertEquals("Test UserDTO", savedUser.getName(), "The user name should match the expected name");
    }
    @Test
     void updateUser()
    {
        UserDto userDto = new UserDto();
        userDto.setUserid(1);
        userDto.setName("User");

        UserDb userDb = new UserDb();
        userDb.setName("UpdatedUserName");

        when(userRepository.findById(userDto.getUserid())).thenReturn(Optional.of(userDb));
        userServiceImpl.updateUser(userDto.getUserid(), userDto);
        Assertions.assertNotNull(userDb, "User Updated");
    }
    @Test
    void deleteUser()
    {
        UserDb userDb = new UserDb();
        userDb.setUserid(1);

        when(userRepository.findById(userDb.getUserid())).thenReturn(Optional.of(userDb));
        userServiceImpl.deleteUser(userDb.getUserid());
        Assertions.assertNotNull(userDb,"Delete User");
    }
}

