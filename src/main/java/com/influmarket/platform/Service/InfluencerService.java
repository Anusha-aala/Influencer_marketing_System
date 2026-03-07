package com.influmarket.platform.Service;
import com.influmarket.platform.Model.Influencer;

public interface InfluencerService {
    String signin(String influencerEmail, String influencerPassword);
    String signup(Influencer influencer);
    Influencer getByEmail(String InfluencerEmail);
    Influencer updateProfile(String InfluencerEmail,Influencer UpdatedProfile);

}
