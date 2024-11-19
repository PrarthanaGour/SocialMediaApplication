package com.socialmedia.test.repository;

import com.socialmedia.test.entities.FollowInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowInformationRepository extends JpaRepository<FollowInformation,Integer> {
}
