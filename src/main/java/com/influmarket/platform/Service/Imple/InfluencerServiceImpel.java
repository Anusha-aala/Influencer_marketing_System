package com.influmarket.platform.Service.Imple;
import com.influmarket.platform.Model.Influencer;
import com.influmarket.platform.Repository.InfluencerRepo;
import com.influmarket.platform.Service.InfluencerService;
import com.influmarket.platform.config.JwtUtil;
import com.influmarket.platform.Model.Roles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Service
public class  InfluencerServiceImpel implements InfluencerService {
    @Autowired
    private InfluencerRepo repo;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
private JwtUtil jwtUtil;
@Override
public String signin(String email, String password) {

    Influencer influencer = repo.findByInfluencerEmail(email);

    if (influencer != null && passwordEncoder.matches(password, influencer.getInfluencerPassword())) {

        return jwtUtil.generateToken(influencer.getInfluencerEmail(), influencer.getRole().name());

    } else {
        throw new RuntimeException("Invalid Credentials");
    }
}
    @Override
    public String signup(Influencer influencer) {
        // assign default role if client omits it
        if (influencer.getRole() == null) {
            influencer.setRole(Roles.ROLE_INFLUENCER);
        }

        if(influencer.getInfluencerEmail()!=null && !influencer.getInfluencerEmail().isEmpty()){
            Influencer existinguser = repo.findByInfluencerEmail(influencer.getInfluencerEmail());
            if(existinguser==null){
                influencer.setInfluencerPassword(
                        passwordEncoder.encode(influencer.getInfluencerPassword())
                );

                repo.save(influencer);
                return "Registration successful";
            }
        }

        return "User With this mail is already exist";
    }
        public List<Influencer> getAllInfluencers(){
            return repo.findAll();
        }
        public Influencer getByEmail(String InfluencerEmail){
            return repo.findByInfluencerEmail(InfluencerEmail);
        }
        public Influencer updateProfile(String InfluencerEmail,Influencer updatedProfile){
            Influencer influencer=repo.findByInfluencerEmail(InfluencerEmail);
            influencer.setInfluencerBio(updatedProfile.getInfluencerName());
            influencer.setInfluencerCategory(updatedProfile.getInfluencerCategory());
            influencer.setInfluencerLocation(updatedProfile.getInfluencerLocation());
            influencer.setInfluencerProfilePictureLink(updatedProfile.getInfluencerProfilePictureLink());
            influencer.setInfluencerPortfolio(updatedProfile.getInfluencerPortfolio());
            return repo.save(influencer);

        }
        public Influencer getProfile(String InfluEmail){
            return repo.findByInfluencerEmail(InfluEmail);
            
        }
        public Influencer save(Influencer existing) {
            //emented method 'save'");
            return repo.save(existing);
        }
        
    
    
}
