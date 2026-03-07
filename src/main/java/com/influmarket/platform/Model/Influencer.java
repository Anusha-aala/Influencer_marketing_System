package com.influmarket.platform.Model;
import jakarta.persistence.*;
@Entity
@Table(name = "users")
public class Influencer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int influencerId;
    private String influencerPassword;
    private String influencerName;
    private String influencerEmail;
    private String influencerPhone;
    private String influencerWhatsappnumber;
    private String influencerCategory;
    private String influencerInstagramProfileLink;
    private String influencerYoutubeProfileLink;
    private int influencerTrustScore;
    private String influencerLocation;
    private String influencerBio;
    private String influencerProfilePictureLink;
    private String influencerPortfolio;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "VARCHAR(255)")
    private Roles role;

    // default constructor assigns influencer role to avoid nullability problems
    public Influencer(){
        this.role = Roles.ROLE_INFLUENCER;
    }
    public void setInfluencerName(String influencerName){
        this.influencerName=influencerName;
    }
    public void setInfluencerPassword(String influencerPassword){
        this.influencerPassword=influencerPassword;
    }
    public void setInfluencerEmail(String influencerEmail){
        this.influencerEmail=influencerEmail;
    }
    public void setInfluencerPhone(String influencerPhone){
        this.influencerPhone=influencerPhone;
    }
    public void setInfluencerWhatsappnumber(String influencerWhatsappnumber){
        this.influencerWhatsappnumber=influencerWhatsappnumber;
    }
    public void setInfluencerCategory(String influencerCategory){
        this.influencerCategory=influencerCategory;
    }
    public void setInfluencerInstagramProfileLink(String influencerInstagramProfileLink){
        this.influencerInstagramProfileLink=influencerInstagramProfileLink;
    }
    public void setInfluencerYoutubeProfileLink(String influencerYoutubeProfileLink){
        this.influencerYoutubeProfileLink=influencerYoutubeProfileLink;
    }
    public void setInfluencerTrustScore(int influencerTrustScore){
        this.influencerTrustScore=influencerTrustScore;
    }
    public void setInfluencerLocation(String influencerLocation){
        this.influencerLocation=influencerLocation;
    }
    public void setInfluencerBio(String influencerBio){
        this.influencerBio=influencerBio;
    }
    public void setInfluencerProfilePictureLink(String influencerProfilePictureLink){
        this.influencerProfilePictureLink=influencerProfilePictureLink;
    }
    public void setInfluencerPortfolio(String influencerPortfolio){
        this.influencerPortfolio=influencerPortfolio;
    }
    public void setRole(Roles role){
        this.role = role;
    }
    public int getInfluencerId(){
        return influencerId;
    }
    public String getInfluencerName(){
        return influencerName;
    }
    public String getInfluencerString(){
        return influencerPassword;
    }
    public String getInfluencerEmail(){
        return influencerEmail;
    }
    public String getInfluencerPhone(){
        return influencerPhone;
    }
    public String getInfluencerWhatsappnumber(){
        return influencerWhatsappnumber;
    }
    public String getInfluencerCategory(){
        return influencerCategory;
    }
    public String getInfluencerInstagramProfileLink(){
        return influencerInstagramProfileLink;
    }
    public String getInfluencerYoutubeProfileLink(){
        return influencerYoutubeProfileLink;
    }
    public int getInfluencerTrustScore(){
        return influencerTrustScore;
    }
    public String getInfluencerLocation(){
        return influencerLocation;
    }
    public String getInfluencerBio(){
        return influencerBio;
    }
    public String getInfluencerProfilePictureLink(){
        return influencerProfilePictureLink;
    }
    public String getInfluencerPortfolio(){
        return influencerPortfolio;
    }
    public String getInfluencerPassword(){
        return influencerPassword;
    }
    public Roles getRole(){
        return role;
    }
}
