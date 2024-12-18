package com.turtlesoup.backend.entity;

import com.turtlesoup.backend.entity.enums.OAuthMethodEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "user")
@Getter
@NoArgsConstructor
public class UserEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "user_email")
    private String email;

    @Column(name = "user_oauth_method")
    private OAuthMethodEnum oAuthMethodEnum;

    @Column(name = "user_password")
    private String password;

    @Column(name = "user_name")
    private String name;

    public UserEntity(String email, OAuthMethodEnum oAuthMethodEnum, String password, String name){
        this.email = email;
        this.oAuthMethodEnum = oAuthMethodEnum;
        this.password = password;
        this.name = name;
    }
}
