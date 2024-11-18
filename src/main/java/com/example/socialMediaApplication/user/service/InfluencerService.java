package com.example.socialMediaApplication.user.service;

import com.example.socialMediaApplication.user.dto.InfluencerDto;

import java.util.List;

public interface InfluencerService
{
    public List<InfluencerDto> getInfluencer();
    public InfluencerDto addInfluencer(InfluencerDto influencerDto);
    public InfluencerDto updateInfluencer(Integer influencerid,InfluencerDto influencerDto);
    public void deleteInfluencer(Integer influencerId);
}
