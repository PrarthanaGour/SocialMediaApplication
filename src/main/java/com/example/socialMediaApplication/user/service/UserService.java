package com.example.socialMediaApplication.user.service;

import com.example.socialMediaApplication.user.dto.UserDto;
import com.example.socialMediaApplication.user.entities.FollowInformation;

import java.util.List;

public interface UserService
{
  public List<UserDto> getUsers();
  public UserDto addUser(UserDto userDto);
  public UserDto updateUser(Integer userId,UserDto userDto);
  public void deleteUser(Integer userId);
  public FollowInformation followInfluencer(Integer userId, Integer influencerId);
  public UserDto getUser(Integer userId);
}
