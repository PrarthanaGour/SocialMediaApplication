package com.socialmedia.test.service;

import com.socialmedia.test.dto.UserDto;
import com.socialmedia.test.entities.FollowInformation;

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
