package com.example.socialMediaApplication.user.dto;

import lombok.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class UserDto{
    private Integer userid;
    private String name;
    private String password;
    private String phone;

    public InfluencerDto influencerDto;

    public List<FollowInformationDto> followInformation;

}
