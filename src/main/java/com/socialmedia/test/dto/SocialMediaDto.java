package com.socialmedia.test.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class SocialMediaDto
{

    private Integer mediaId;
    private String name;
    private boolean facebook;
    private boolean twitter;
    private boolean instagram;

    private UserDto user;


}
