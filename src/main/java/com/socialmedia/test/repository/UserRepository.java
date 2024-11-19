package com.socialmedia.test.repository;

import com.socialmedia.test.entities.UserDb;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDb, Integer>
{
}
