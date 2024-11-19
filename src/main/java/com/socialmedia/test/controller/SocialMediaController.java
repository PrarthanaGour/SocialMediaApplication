package com.socialmedia.test.controller;

import com.socialmedia.test.dto.SocialMediaDto;
import com.socialmedia.test.service.SocialMediaAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SocialMediaController
{

    private final SocialMediaAccountService socialMediaAccountService;

    public SocialMediaController(SocialMediaAccountService socialMediaAccountService) {
        this.socialMediaAccountService = socialMediaAccountService;
    }

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
    @PutMapping("/updateSocialMediaAccount/{mediaId}")
    public SocialMediaDto updateSocialMedia(@PathVariable Integer mediaId, @RequestBody SocialMediaDto socialMediaDto)
    {
        return socialMediaAccountService.updateSocialMedia(mediaId,socialMediaDto);
    }
    @DeleteMapping("/SocialMediaAccount/{mediaId}")
    public void deleteSocialMedia(@PathVariable Integer mediaId)
    {
       socialMediaAccountService.deleteSocialMediaAccount(mediaId);
    }
}
