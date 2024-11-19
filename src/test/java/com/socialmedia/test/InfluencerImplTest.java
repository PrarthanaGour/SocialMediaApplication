package com.socialmedia.test;

import com.socialmedia.test.dto.InfluencerDto;
import com.socialmedia.test.entities.Influencer;
import com.socialmedia.test.repository.InfluencerRepository;
import com.socialmedia.test.implementation.InfluencerServiceImpl;
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
class InfluencerImplTest
{
    @InjectMocks
    private InfluencerServiceImpl influencerServiceImpl;

    @Mock
    private InfluencerRepository influencerRepository;

    @Mock
    private ModelMapper modelMapper;


    @Test
     void getInfluencer() {
        Influencer influencer = new Influencer();
        influencer.setUsername("Test Influencer");

        InfluencerDto influencerDto = new InfluencerDto();
        influencerDto.setUsername("Test InfluencerDto");

        when(influencerRepository.findAll()).thenReturn(Collections.singletonList(influencer));
        when(modelMapper.map(influencer,InfluencerDto.class)).thenReturn(influencerDto);

        List<InfluencerDto> influencers = influencerServiceImpl.getInfluencer();
        assertFalse(influencers.isEmpty(), "Influencer list should not be empty");
        assertTrue(influencers.stream().anyMatch(influencersDto1->influencersDto1.getUsername().equals("Test InfluencerDto")),
                "Test Influencer should be in influencer list");
    }

    @Test
    void addInfluencer() {
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
     void updateInfluencer()
    {
        InfluencerDto influencerDto = new InfluencerDto();
        influencerDto.setInfluencerId(1);
        influencerDto.setUsername("Influencer");

        Influencer influencer=new Influencer();
        influencer.setUsername("UpdatedUserName");

        when(influencerRepository.findById(influencerDto.getInfluencerId())).thenReturn(Optional.of(influencer));
         influencerServiceImpl.updateInfluencer(influencerDto.getInfluencerId(),influencerDto);
        Assertions.assertNotNull(influencer , "UpdatedUserName");
    }
    @Test
     void deleteInfluencer()
    {
        Influencer influencer = new Influencer();
        influencer.setInfluencerid(1);

        influencerServiceImpl.deleteInfluencer(influencer.getInfluencerid());
        Assertions.assertNotNull(influencer,"Deleted influencer");
    }
}



