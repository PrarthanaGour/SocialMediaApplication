package com.example.socialMediaApplication.user;

import com.example.socialMediaApplication.user.dto.SocialMediaDto;
import com.example.socialMediaApplication.user.entities.SocialMediaAccount;
import com.example.socialMediaApplication.user.repository.SocialMediaAccountRepository;
import com.example.socialMediaApplication.user.service.Implimentation.SocialMediaAccountServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SocialMediaImplTest
{
    @InjectMocks
    private SocialMediaAccountServiceImpl socialMediaAccountServiceImpl;

    @Mock
    private SocialMediaAccountRepository socialMediaAccountRepository;

    @Mock
    private ModelMapper modelMapper;

    @Test
    public void  getSocialMediaAccount()
    {
        SocialMediaAccount socialMediaAccount=new SocialMediaAccount();
        socialMediaAccount.setName("Social Media");

        SocialMediaDto socialMediaDto = new SocialMediaDto();
        socialMediaDto.setName("Test Social Media");

        when(socialMediaAccountRepository.findAll()).thenReturn(Collections.singletonList(socialMediaAccount));
        when(modelMapper.map(socialMediaAccount,SocialMediaDto.class)).thenReturn(socialMediaDto);

        List<SocialMediaDto> socialMediaDtoList = socialMediaAccountServiceImpl.getSocialMediaAccount();
        assertFalse(socialMediaDtoList.isEmpty(), "Users list should not be empty");
        assertTrue(socialMediaDtoList.stream().anyMatch(socialMediaDtoList2 -> socialMediaDtoList2.getName()
                .equals("Test Social Media")),"Test SocialMedia");
    }
    @Test
    public void addSocialMedia()
    {
        SocialMediaDto socialMediaDto=new SocialMediaDto();
        socialMediaDto.setName("Test SocialMediaDto");

        SocialMediaAccount socialMediaAccount=new SocialMediaAccount();
        socialMediaAccount.setName("SocialMediaAccount");

        doReturn(socialMediaAccount).when(modelMapper).map(socialMediaDto,SocialMediaAccount.class);
        doReturn(socialMediaDto).when(modelMapper).map(socialMediaAccount,SocialMediaDto.class);

        when(socialMediaAccountRepository.save(socialMediaAccount)).thenReturn(socialMediaAccount);
        SocialMediaDto savedSocialMediaAccount=socialMediaAccountServiceImpl.addSocialMedia(socialMediaDto);

        Assertions.assertNotNull(savedSocialMediaAccount, "Influencer should not be null");
        Assertions.assertEquals("Test SocialMediaDto", savedSocialMediaAccount.getName(), "The user name should match the expected name");
    }
    @Test
    public void updateSocialMedia() {
        SocialMediaDto socialMediaDto = new SocialMediaDto();
        socialMediaDto.setMediaId(1);
        socialMediaDto.setName("SocialMedia");

        SocialMediaAccount socialMediaAccount = new SocialMediaAccount();
        socialMediaAccount.setName("UpdatedSocialMedia");

        when(socialMediaAccountRepository.findById(socialMediaDto.getMediaId())).thenReturn(Optional.of(socialMediaAccount));
        SocialMediaDto socialMediaDto1 = socialMediaAccountServiceImpl.updateSocialMedia(socialMediaDto.getMediaId(), socialMediaDto);
        Assertions.assertNotEquals(socialMediaAccount, "SocialMediaAccountUpdated");
    }
    @Test
    public void deleteSocialMedia()
    {
        SocialMediaAccount socialMediaAccount=new SocialMediaAccount();
        socialMediaAccount.setMediaId(1);
        socialMediaAccountServiceImpl.deleteSocialMediaAccount(1);
    }
}
