package com.socialmedia.test.dto;

import com.socialmedia.test.entities.Influencer;
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

    private Influencer influencer;

    private List<FollowInformationDto> followInformation;

}
