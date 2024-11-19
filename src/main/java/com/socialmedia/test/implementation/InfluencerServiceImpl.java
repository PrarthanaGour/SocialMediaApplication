package com.socialmedia.test.implementation;

import com.socialmedia.test.dto.InfluencerDto;
import com.socialmedia.test.entities.Influencer;
import com.socialmedia.test.repository.InfluencerRepository;
import com.socialmedia.test.service.InfluencerService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InfluencerServiceImpl implements InfluencerService
{

    private final InfluencerRepository influencerRepository;


    private final ModelMapper modelMapper;

    List<InfluencerDto> list;

    public InfluencerServiceImpl(InfluencerRepository influencerRepository, ModelMapper modelMapper) {
        this.influencerRepository = influencerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<InfluencerDto> getInfluencer() {
        List<Influencer> influencerList = influencerRepository.findAll();
        List<InfluencerDto> influencerDtoList = new ArrayList<>();
        for (Influencer influencer : influencerList) {
            InfluencerDto influencerDto= modelMapper.map(influencer, InfluencerDto.class);
            influencerDtoList.add(influencerDto);
        }
        return influencerDtoList;
    }
    @Override
    public InfluencerDto addInfluencer(InfluencerDto influencerDto) {
        Influencer influencer = modelMapper.map(influencerDto,Influencer.class);
         influencer= influencerRepository.save(influencer);
         modelMapper.map(influencer,InfluencerDto.class);
        return influencerDto;
    }
    @Override
    public InfluencerDto updateInfluencer(Integer id, InfluencerDto influencerDto)
   {
       Influencer influencer =modelMapper.map(influencerDto,Influencer.class);
       influencerRepository.findById(id);
       influencerRepository.save(influencer);
       modelMapper.map(influencer,InfluencerDto.class);
       return influencerDto;
   }
    @Override
    public void deleteInfluencer(Integer id)
    {
        influencerRepository.deleteById(id);
    }
}
