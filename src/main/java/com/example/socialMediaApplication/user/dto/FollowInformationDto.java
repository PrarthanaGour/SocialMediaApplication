package com.example.socialMediaApplication.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class FollowInformationDto
{
    private Integer followInformationId;

    public UserDto user;
    public InfluencerDto influencer;
}
