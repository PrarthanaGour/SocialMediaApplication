package com.example.socialMediaApplication.user;

import com.example.socialMediaApplication.user.dto.InfluencerDto;
import com.example.socialMediaApplication.user.entities.Influencer;
import com.example.socialMediaApplication.user.repository.InfluencerRepository;
import com.example.socialMediaApplication.user.service.Implimentation.InfluencerServiceImpl;
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
public class InfluencerImplTest
{
    @InjectMocks
    private InfluencerServiceImpl influencerServiceImpl;

    @Mock
    private InfluencerRepository influencerRepository;

    @Mock
    private ModelMapper modelMapper;


    @Test
    public void getInfluencer() {
        Influencer influencer = new Influencer();
        influencer.setUsername("Test Influencer");

        List<Influencer> influencersList = Collections.singletonList(influencer);
        when(influencerRepository.findAll()).thenReturn(influencersList);
        List<InfluencerDto> influencer1 = influencerServiceImpl.getInfluencer();
        assertFalse(influencersList.isEmpty(), "Influencer list should not be empty");
        assertTrue(influencersList.stream().anyMatch(dto -> dto.getUsername().equals("Test Influencer")),
                "Test Influencer should be in the influencers list");
    }
    @Test
    public void addInfluencer() {
        InfluencerDto influencerDto=new InfluencerDto();
        influencerDto.setUsername("Test InfluencerDto");

        Influencer influencer = new Influencer();
        influencer.setUsername("Test Influencer");

        doReturn(influencer).when(modelMapper).map(influencerDto, Influencer.class);
        doReturn(influencerDto).when(modelMapper).map(influencer, InfluencerDto.class);

        when(influencerRepository.save(influencer)).thenReturn(influencer);
        InfluencerDto savedInfluencer = influencerServiceImpl.addInfluencer(influencerDto);

        Assertions.assertNotNull(savedInfluencer, "Influencer should not be null");
        Assertions.assertEquals("Test InfluencerDto", savedInfluencer.getUsername(), "The user name should match the expected name");
    }
    @Test
    public void updateInfluencer()
    {
        InfluencerDto influencerDto = new InfluencerDto();
        influencerDto.setInfluencerId(1);
        influencerDto.setUsername("Influencer");

        Influencer influencer=new Influencer();
        influencer.setUsername("UpdatedUserName");

        when(influencerRepository.findById(influencerDto.getInfluencerId())).thenReturn(Optional.of(influencer));
        InfluencerDto InfluencerDto1 = influencerServiceImpl.updateInfluencer(influencerDto.getInfluencerId(),influencerDto);
        Assertions.assertNotEquals(influencer, "Influencer Updated");
    }
    @Test
    public void deleteInfluencer()
    {
        Influencer influencer = new Influencer();
        influencer.setInfluencerId(1);

        influencerServiceImpl.deleteInfluencer(influencer.getInfluencerId());
    }
}



