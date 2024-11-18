package com.example.socialMediaApplication.user.service;

import com.example.socialMediaApplication.user.dto.SocialMediaDto;

import java.util.List;

public interface SocialMediaAccountService
{
    public List<SocialMediaDto> getSocialMediaAccount();
    public SocialMediaDto addSocialMedia(SocialMediaDto socialMediaDto);
    public SocialMediaDto updateSocialMedia(Integer mediaId,SocialMediaDto socialMediaDto);
    public void deleteSocialMediaAccount(Integer mediaId);
}
