package com.example.socialMediaApplication.user.service.Implimentation;

import com.example.socialMediaApplication.user.dto.SocialMediaDto;
import com.example.socialMediaApplication.user.entities.SocialMediaAccount;
import com.example.socialMediaApplication.user.repository.SocialMediaAccountRepository;
import com.example.socialMediaApplication.user.service.SocialMediaAccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SocialMediaAccountServiceImpl implements SocialMediaAccountService
{
    @Autowired
    private SocialMediaAccountRepository socialMediaAccountRepository;

    @Autowired
    private ModelMapper modelMapper;


    List<SocialMediaDto> list;

    @Override
    public List<SocialMediaDto> getSocialMediaAccount() {
        List<SocialMediaAccount> socialMediaAccountlist = socialMediaAccountRepository.findAll();
        List<SocialMediaDto> socialMediaDtoList = new ArrayList<>();
        for (SocialMediaAccount socialMediaAccount : socialMediaAccountlist) {
            SocialMediaDto socialMediaDto = modelMapper.map(socialMediaAccount,SocialMediaDto.class);
            socialMediaDtoList.add(socialMediaDto);
        }
        return socialMediaDtoList;
    }

    @Override
    public SocialMediaDto addSocialMedia(SocialMediaDto socialMediaDto) {
        SocialMediaAccount socialMediaAccount = modelMapper.map(socialMediaDto,SocialMediaAccount.class);
        socialMediaAccount=socialMediaAccountRepository.save(socialMediaAccount);
        SocialMediaDto savedSocialMediaDto=modelMapper.map(socialMediaAccount,SocialMediaDto.class);
        return savedSocialMediaDto;
    }

    @Override
    public SocialMediaDto updateSocialMedia(Integer mediaId, SocialMediaDto socialMediaDto)
    {
        SocialMediaAccount socialMediaAccount =modelMapper.map(socialMediaDto,SocialMediaAccount.class);
        socialMediaAccountRepository.findById(mediaId).orElseThrow(()->new RuntimeException("MediaId not found"));
        socialMediaAccountRepository.save(socialMediaAccount);
        SocialMediaDto updatedSocialMedia=modelMapper.map(socialMediaAccount,SocialMediaDto.class);
        return updatedSocialMedia;
    }
    @Override
    public void deleteSocialMediaAccount(Integer mediaId)
    {
        socialMediaAccountRepository.deleteById(mediaId);
    }
}
