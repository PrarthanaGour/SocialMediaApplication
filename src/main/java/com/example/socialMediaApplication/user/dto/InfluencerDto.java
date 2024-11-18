package com.example.socialMediaApplication.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class InfluencerDto
{
    private Integer influencerId;
    private String username;
    private String password;

    public List<FollowInformationDto> followInformationDtoList;


}
