package com.socialmedia.test.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class Influencer
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer influencerid;
    private String username;
    private String password;

   @OneToMany(mappedBy = "influencer", cascade = CascadeType.ALL)
   private List<FollowInformation> followers;

}
