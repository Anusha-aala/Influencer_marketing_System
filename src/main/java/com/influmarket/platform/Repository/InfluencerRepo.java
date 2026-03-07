package com.influmarket.platform.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.influmarket.platform.Model.Influencer;
public interface InfluencerRepo extends JpaRepository<Influencer,Integer>{
    Influencer findByInfluencerEmail(String influencerEmail);
    
} 
