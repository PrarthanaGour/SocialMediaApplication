package com.example.socialMediaApplication.user.service.Implimentation;

import com.example.socialMediaApplication.user.dto.UserDto;
import com.example.socialMediaApplication.user.entities.FollowInformation;
import com.example.socialMediaApplication.user.entities.Influencer;
import com.example.socialMediaApplication.user.entities.UserDb;
import com.example.socialMediaApplication.user.exception.UserNotFoundException;
import com.example.socialMediaApplication.user.repository.InfluencerRepository;
import com.example.socialMediaApplication.user.repository.UserRepository;
import com.example.socialMediaApplication.user.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private InfluencerRepository influencerRepository;

    @Autowired
    private ModelMapper modelMapper;


    List<UserDto> list;

    public List<UserDto> getUsers() {
        List<UserDb> userDbList = userRepository.findAll();
        List<UserDto> userDtoList = new ArrayList<>();
        for (UserDb userDb : userDbList) {
            UserDto userDto = modelMapper.map(userDb, UserDto.class);
            userDtoList.add(userDto);
        }
        return userDtoList;
    }

    public UserDto getUser(Integer userId)
    {
        Optional<UserDb> userDb = userRepository.findById(userId);
        if (!userDb.isPresent()){
            throw new UserNotFoundException("User not found with this id: "+userId);
        }
        UserDto userDto=modelMapper.map(userDb,UserDto.class);
      return userDto;
    }

    public UserDto addUser(UserDto userDto) {
        if(!validPhoneNumber(userDto.getPhone()))
        {
            throw new IllegalArgumentException("Phone number must contain only 10 digit");
        }
        UserDb userDb = modelMapper.map(userDto,UserDb.class);
        userDb  = userRepository.save(userDb);
        UserDto savedUserData=modelMapper.map(userDb,UserDto.class);
        return savedUserData;
    }

    @Override
    public UserDto updateUser(Integer id,UserDto userDto)
    {
        UserDb userDb =modelMapper.map(userDto,UserDb.class);
        userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found"));
        userRepository.save(userDb);
        UserDto updatedUser=modelMapper.map(userDb,UserDto.class);
        return updatedUser;
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
        UserDto userResponseDto = new UserDto();
        UserDb userDb = userRepository.findById(userId).orElse(null);

        Influencer influencer = influencerRepository.findById(influencerId).orElse(null);

        FollowInformation followInformation = new FollowInformation();
        followInformation.setInfluencer(influencer);
        followInformation.setUser(userDb);
        return followInformation;
    }

    private boolean validPhoneNumber(String phone)
    {
        if(phone.length()!=10)
        {
            return false;
        }
        return true;
    }
}

