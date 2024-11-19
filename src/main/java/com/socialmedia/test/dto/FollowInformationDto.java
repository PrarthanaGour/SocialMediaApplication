package com.socialmedia.test.dto;

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

    private UserDto user;
    private InfluencerDto influencer;
}
