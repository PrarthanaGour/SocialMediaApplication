package com.socialmedia.test.service;

import com.socialmedia.test.dto.FollowInformationDto;

public interface FollowInformationService {
    FollowInformationDto follow(Integer userId, Integer influencerId);
}

