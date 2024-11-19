package com.socialmedia.test.repository;

import com.socialmedia.test.entities.Influencer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface InfluencerRepository extends JpaRepository<Influencer,Integer> {
}
