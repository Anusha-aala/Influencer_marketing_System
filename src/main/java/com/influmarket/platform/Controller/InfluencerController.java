package com.influmarket.platform.Controller;
import org.springframework.web.bind.annotation.*;

import com.influmarket.platform.Model.Influencer;
import com.influmarket.platform.Service.Imple.InfluencerServiceImpel;

import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;



@RestController
@RequestMapping("/influencers")
public class InfluencerController {
    @Autowired
    private InfluencerServiceImpel influencerService;
    @PostMapping("/signup")
    public String registerInfluencer(@RequestBody Influencer influencer){
        return influencerService.signup(influencer);
    }
    @PostMapping("/signin")
    public String loginInfluencer(@RequestBody Influencer influencer){
        return influencerService.signin(influencer.getInfluencerEmail(), influencer.getInfluencerPassword());
    }
    @GetMapping
    public String getInfluencerDetails(){
        return "Details of influencer: " + influencerService.getAllInfluencers();
    }
    @GetMapping("/profile")
    public Influencer getProfile(Authentication authentication){
        String InfluEmail=authentication.getName();
        return influencerService.getProfile(InfluEmail);
    }
    @PutMapping("profile/{id}")
    public Influencer updateData(@PathVariable("id") int influencerId, @RequestBody Influencer influencer,Authentication authentication) {
        String Influemail=authentication.getName();
        Influencer existing=influencerService.getProfile(Influemail);
        existing.setInfluencerBio(influencer.getInfluencerName());
            existing.setInfluencerCategory(influencer.getInfluencerCategory());
            existing.setInfluencerLocation(influencer.getInfluencerLocation());
            existing.setInfluencerProfilePictureLink(influencer.getInfluencerProfilePictureLink());
            existing.setInfluencerPortfolio(influencer.getInfluencerPortfolio());
            return influencerService.save(existing);
    }
}
    