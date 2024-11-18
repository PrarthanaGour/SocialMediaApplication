package com.example.socialMediaApplication.user.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class SocialMediaAccount
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mediaId;
    private String name;
    private boolean facebook;
    private boolean twitter;
    private boolean instagram;

    @OneToOne(cascade = CascadeType.ALL)
    private UserDb user;

}
