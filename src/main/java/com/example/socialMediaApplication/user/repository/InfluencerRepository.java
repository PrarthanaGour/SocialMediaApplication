package com.example.socialMediaApplication.user.repository;

import com.example.socialMediaApplication.user.entities.Influencer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface InfluencerRepository extends JpaRepository<Influencer,Integer> {
}
