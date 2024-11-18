package com.example.socialMediaApplication.user.service.Implimentation;

import com.example.socialMediaApplication.user.dto.InfluencerDto;
import com.example.socialMediaApplication.user.entities.Influencer;
import com.example.socialMediaApplication.user.repository.InfluencerRepository;
import com.example.socialMediaApplication.user.service.InfluencerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InfluencerServiceImpl implements InfluencerService
{
    @Autowired
    private InfluencerRepository influencerRepository;

    @Autowired
    private ModelMapper modelMapper;

    List<InfluencerDto> influencerDto;

    @Override
    public List<InfluencerDto> getInfluencer() {
        List<Influencer> influencer = influencerRepository.findAll();
        List<InfluencerDto> influencerDto = new ArrayList<>();
        for (Influencer influencer1 : influencer) {
            InfluencerDto influencerDto1 = new InfluencerDto();
            modelMapper.map(influencer1, influencerDto1);
            influencerDto.add(influencerDto1);
        }
        return influencerDto;
    }

    @Override
    public InfluencerDto addInfluencer(InfluencerDto influencerDto) {
        Influencer influencer = modelMapper.map(influencerDto,Influencer.class);
         influencer= influencerRepository.save(influencer);
         modelMapper.map(influencer,InfluencerDto.class);
        return influencerDto;
    }
    public InfluencerDto updateInfluencer(Integer id, InfluencerDto influencerDto)
   {
       Influencer influencer =modelMapper.map(influencerDto,Influencer.class);
       influencerRepository.findById(id).orElseThrow(()->new RuntimeException("Influencer not found"));
       influencerRepository.save(influencer);
       InfluencerDto updatedInfluencer=modelMapper.map(influencer,InfluencerDto.class);
       return updatedInfluencer;
   }
    @Override
    public void deleteInfluencer(Integer id)
    {
      influencerRepository.deleteById(id);
    }
}
