package com.example.socialMediaApplication.user.repository;

import com.example.socialMediaApplication.user.entities.SocialMediaAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocialMediaAccountRepository extends JpaRepository<SocialMediaAccount , Integer> {
}
