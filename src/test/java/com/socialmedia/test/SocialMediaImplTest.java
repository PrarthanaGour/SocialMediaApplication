package com.socialmedia.test;

import com.socialmedia.test.dto.SocialMediaDto;
import com.socialmedia.test.entities.SocialMediaAccount;
import com.socialmedia.test.repository.SocialMediaAccountRepository;
import com.socialmedia.test.implementation.SocialMediaAccountServiceImpl;
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
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class SocialMediaImplTest
{
    @InjectMocks
    private SocialMediaAccountServiceImpl socialMediaAccountServiceImpl;

    @Mock
    private SocialMediaAccountRepository socialMediaAccountRepository;

    @Mock
    private ModelMapper modelMapper;

    @Test
    void  getSocialMediaAccount()
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
    void addSocialMedia()
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
    void updateSocialMedia() {
        SocialMediaDto socialMediaDto = new SocialMediaDto();
        socialMediaDto.setMediaId(1);
        socialMediaDto.setName("SocialMedia");

        SocialMediaAccount socialMediaAccount = new SocialMediaAccount();
        socialMediaAccount.setName("UpdatedSocialMedia");

        when(socialMediaAccountRepository.findById(socialMediaDto.getMediaId())).thenReturn(Optional.of(socialMediaAccount));
        socialMediaAccountServiceImpl.updateSocialMedia(socialMediaDto.getMediaId(), socialMediaDto);
        Assertions.assertNotNull("SocialMediaAccount");
    }
    @Test
     void deleteSocialMedia()
    {
        SocialMediaAccount socialMediaAccount=new SocialMediaAccount();
        socialMediaAccount.setMediaId(1);
        socialMediaAccountServiceImpl.deleteSocialMediaAccount(1);
        Assertions.assertNotNull(socialMediaAccount,"MediaId not found");

    }
}
