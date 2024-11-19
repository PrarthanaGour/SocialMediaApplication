package com.socialmedia.test.repository;

import com.socialmedia.test.entities.SocialMediaAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocialMediaAccountRepository extends JpaRepository<SocialMediaAccount, Integer> {
}
