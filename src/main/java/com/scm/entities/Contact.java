package com.scm.entities;

import java.util.ArrayList;

import org.springframework.web.multipart.MultipartFile;

import java.util.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
    
    @Id  
    private String id;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private boolean favorite = false;
    @Column(length = 1000)
    private String description;
    private String WebsiteLink;
    private String LinkedInLink;

    @ManyToOne
    private User user;
      
    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<SocialLink> links = new ArrayList<>();

    public void setContactId(String contactId) {    
        this.id = contactId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWebsiteLink() {
        return WebsiteLink;
    }

    public void setWebsiteLink(String WebsiteLink) {
        this.WebsiteLink = WebsiteLink;
    }

    public String getLinkedInLink() {
        return LinkedInLink;
    }

    public void setLinkedInLink(String LinkedInLink) {
        this.LinkedInLink = LinkedInLink;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<SocialLink> getLinks() {
        return links;
    }

    public void setLinks(List<SocialLink> links) {
        this.links = links;
    }

    public void setProfileImage(MultipartFile profileImage) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setProfileImage'");
    }

}
