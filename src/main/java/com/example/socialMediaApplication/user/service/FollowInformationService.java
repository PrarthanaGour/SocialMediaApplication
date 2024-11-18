package com.example.socialMediaApplication.user.service;

import com.example.socialMediaApplication.user.dto.FollowInformationDto;

public interface FollowInformationService {
    FollowInformationDto follow(Integer userId, Integer influencerId);
}

