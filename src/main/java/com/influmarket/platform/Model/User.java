package com.influmarket.platform.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "app_user")  // avoid H2 reserved keyword 'USER'
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long InfluencerId;

    private String influencerEmail;
    private String influencerPassword;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "VARCHAR(255)") // force VARCHAR to avoid H2 enum syntax
    private Roles role;
}