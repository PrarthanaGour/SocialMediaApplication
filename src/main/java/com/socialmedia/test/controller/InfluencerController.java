package com.socialmedia.test.controller;

import com.socialmedia.test.dto.InfluencerDto;
import com.socialmedia.test.service.InfluencerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class InfluencerController
{

    private final InfluencerService influencerService;

    public InfluencerController(InfluencerService influencerService) {
        this.influencerService = influencerService;
    }

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
    @PutMapping("updateInfluencer/{influencerId}")
    public  InfluencerDto updateInfluencer(@PathVariable Integer influencerId,@RequestBody InfluencerDto influencerDto)
    {
        return influencerService.updateInfluencer(influencerId,influencerDto);
    }
    @DeleteMapping("/influencers/{influencerId}")
    public void deleteInfluencer(@PathVariable Integer influencerId)
    {
      influencerService.deleteInfluencer(influencerId);
    }
}
