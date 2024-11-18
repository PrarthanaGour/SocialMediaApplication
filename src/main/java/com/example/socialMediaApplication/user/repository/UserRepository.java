package com.example.socialMediaApplication.user.repository;

import com.example.socialMediaApplication.user.entities.UserDb;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDb, Integer>
{
}
