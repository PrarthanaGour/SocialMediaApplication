package com.socialmedia.test.implementation;

import com.socialmedia.test.dto.UserDto;
import com.socialmedia.test.entities.FollowInformation;
import com.socialmedia.test.entities.Influencer;
import com.socialmedia.test.entities.UserDb;
import com.socialmedia.test.exception.UserNotFoundException;
import com.socialmedia.test.repository.InfluencerRepository;
import com.socialmedia.test.repository.UserRepository;
import com.socialmedia.test.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final InfluencerRepository influencerRepository;

    private final ModelMapper modelMapper;

    List<UserDto> list;

    public UserServiceImpl(UserRepository userRepository, InfluencerRepository influencerRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.influencerRepository = influencerRepository;
        this.modelMapper = modelMapper;
    }

    public List<UserDto> getUsers() {
        List<UserDb> userDbList = userRepository.findAll();
        List<UserDto> userDtoList = new ArrayList<>();
        for (UserDb userDb : userDbList) {
            UserDto userDto = modelMapper.map(userDb, UserDto.class);
            userDtoList.add(userDto);
        }
        return userDtoList;
    }

    public UserDto getUser(Integer userId) {
        UserDb userDb = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found with this id: " + userId));
        return modelMapper.map(userDb, UserDto.class);
    }


    public UserDto addUser(UserDto userDto) {
        if(!validPhoneNumber(userDto.getPhone()))
        {
            throw new IllegalArgumentException("Phone number must contain only 10 digit");
        }
        UserDb userDb = modelMapper.map(userDto,UserDb.class);
        userDb  = userRepository.save(userDb);
        modelMapper.map(userDb,UserDto.class);
        return userDto;
    }

    @Override
    public UserDto updateUser(Integer id,UserDto userDto)
    {
        UserDb userDb =modelMapper.map(userDto,UserDb.class);
        userRepository.findById(id);
        userRepository.save(userDb);
        modelMapper.map(userDb,UserDto.class);
        return userDto;
    }

    @Override
    public void deleteUser(Integer userId)
    {
     Optional<UserDb> user = userRepository.findById(userId);
        if (user.isPresent()) {
            userRepository.deleteById(userId);
        }
    }

    @Override
    public FollowInformation followInfluencer(Integer userId, Integer influencerId) {
        UserDb userDb = userRepository.findById(userId).orElse(null);

        Influencer influencer = influencerRepository.findById(influencerId).orElse(null);

        FollowInformation followInformation = new FollowInformation();
        followInformation.setInfluencer(influencer);
        followInformation.setUser(userDb);
        return followInformation;
    }

    private boolean validPhoneNumber(String phone) {
        return phone.length() == 10;
    }

}

