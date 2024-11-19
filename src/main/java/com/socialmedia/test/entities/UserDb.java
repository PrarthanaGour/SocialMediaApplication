package com.socialmedia.test.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class UserDb
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userid;
    private String name;

    private String password;

    @Size(min = 10, max = 10, message = "Phone number must be exactly 10 digits")
    private String phone;

    @OneToOne(cascade = CascadeType.ALL)
    public Influencer influencer;

   @OneToMany
     private List<FollowInformation> followInformation;

    }




