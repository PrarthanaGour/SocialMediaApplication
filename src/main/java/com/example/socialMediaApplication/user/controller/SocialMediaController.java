package com.example.socialMediaApplication.user.controller;

import com.example.socialMediaApplication.user.dto.SocialMediaDto;
import com.example.socialMediaApplication.user.service.SocialMediaAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SocialMediaController
{
    @Autowired
    private SocialMediaAccountService socialMediaAccountService;

    @GetMapping("/allAccounts")
    public List<SocialMediaDto> getSocialMediaAccount()
    {
        return socialMediaAccountService.getSocialMediaAccount();
    }
    @PostMapping("/SocialMediaAccount")
    public SocialMediaDto addSocialMedia(@RequestBody SocialMediaDto socialMediaDto)
    {
        return socialMediaAccountService.addSocialMedia(socialMediaDto);
    }
    @PutMapping("/updateSocialMediaAccount/{SocialMediaId}")
    public SocialMediaDto updateSocialMedia(@PathVariable Integer mediaId, @RequestBody SocialMediaDto socialMediaDto)
    {
        return socialMediaAccountService.updateSocialMedia(mediaId,socialMediaDto);
    }
    @DeleteMapping("/SocialMediaAccount/{id}")
    public void deleteSocialMedia(@PathVariable Integer mediaId)
    {
       socialMediaAccountService.deleteSocialMediaAccount(mediaId);
    }
}
