package com.example.socialMediaApplication.user.controller;

import com.example.socialMediaApplication.user.dto.InfluencerDto;
import com.example.socialMediaApplication.user.service.InfluencerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class InfluencerController
{
    @Autowired
    private InfluencerService influencerService;

    @GetMapping("/all/influencers")
    public List<InfluencerDto> getInfluencer()
    {
        return this.influencerService.getInfluencer();
    }
    @PostMapping("/influencer")
    public InfluencerDto addInfluencer(@RequestBody InfluencerDto influencerDto)
    {
        return this.influencerService.addInfluencer(influencerDto);
    }
    @PutMapping("updateInfluencer/{InfluencerId}")
    public  InfluencerDto updateInfluencer(@PathVariable Integer id,@RequestBody InfluencerDto influencerDto)
    {
        Integer influencerid;
        return influencerService.updateInfluencer(id,influencerDto);
    }
    @DeleteMapping("/influencers/{id}")
    public void deleteInfluencer(@PathVariable Integer influencerId)
    {
      influencerService.deleteInfluencer(influencerId);
    }
}
