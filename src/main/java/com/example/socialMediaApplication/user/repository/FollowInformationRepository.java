package com.example.socialMediaApplication.user.repository;

import com.example.socialMediaApplication.user.entities.FollowInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowInformationRepository extends JpaRepository<FollowInformation,Integer> {
}
