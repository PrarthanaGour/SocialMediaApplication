package com.socialmedia.test.implementation;

import com.socialmedia.test.dto.SocialMediaDto;
import com.socialmedia.test.entities.SocialMediaAccount;
import com.socialmedia.test.repository.SocialMediaAccountRepository;
import com.socialmedia.test.service.SocialMediaAccountService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SocialMediaAccountServiceImpl implements SocialMediaAccountService
{

    private final SocialMediaAccountRepository socialMediaAccountRepository;

    private final ModelMapper modelMapper;


    List<SocialMediaDto> list;

    public SocialMediaAccountServiceImpl(SocialMediaAccountRepository socialMediaAccountRepository, ModelMapper modelMapper) {
        this.socialMediaAccountRepository = socialMediaAccountRepository;
        this.modelMapper = modelMapper;
    }

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
        modelMapper.map(socialMediaAccount,SocialMediaDto.class);
        return socialMediaDto;
    }

    @Override
    public SocialMediaDto updateSocialMedia(Integer mediaId, SocialMediaDto socialMediaDto)
    {
        SocialMediaAccount socialMediaAccount =modelMapper.map(socialMediaDto,SocialMediaAccount.class);
        socialMediaAccountRepository.findById(mediaId);
        socialMediaAccountRepository.save(socialMediaAccount);
        modelMapper.map(socialMediaAccount,SocialMediaDto.class);
        return socialMediaDto;
    }
    @Override
    public void deleteSocialMediaAccount(Integer mediaId)
    {
        socialMediaAccountRepository.deleteById(mediaId);
    }
}
